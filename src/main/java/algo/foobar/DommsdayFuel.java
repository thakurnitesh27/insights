package algo.foobar;

//import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static jdk.nashorn.internal.objects.Global.instance;
import static jdk.nashorn.internal.objects.Global.print;

public class DommsdayFuel {

    public static void main(String[] args) {
        int[][] arr =new int[][]{
                {0,1,0,0,0,1},
                {4,0,0,3,2,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
        print(solution(arr));

        arr=new int[][]{
                {0, 2, 1, 0, 0},
                {0, 0, 0, 3, 4},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0,0},
                {0, 0, 0, 0, 0}

        };
        print(solution(arr));

        arr=new int[][]{
                {0, 1, 0, 0, 0, 1},
                {4, 0, 0, 3, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}

    };
        arr=new int[][]{
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        print(solution(arr));

        arr=new int[][]{
                {6,1,1},
                {4,-2,5},
                {2,8,7}
        };
      //  System.out.println(findDeterminant(arr));
        arr=new int[][]{
                {4,3,2,2},
                {0,1,0,-2},
                {1,-1,3,3},
                {2,3,1,1}
        };
        arr=new int[][]{
                {1,1,1,-1},
                {1,1,-1,1},
                {1,-1,1,1},
                {-1,1,1,1}
        };

//        Factor [][]m1=new Factor[][]{
//                {new Factor(1),new Factor(2),new Factor(3)},
//                {new Factor(4),new Factor(5),new Factor(6)}
//
//        };
//        Factor [][] m2=new Factor[][]{
//                {new Factor(7),new Factor(8)},
//                {new Factor(9),new Factor(10)},
//                {new Factor(11),new Factor(12)},
//        };
//        printMatrix(multiplyMatrices(m1,m2));
    }

    private static void print(int[] ans){
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+"\t");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] determinantForMinorMatrices) {

        for(int i=0;i<determinantForMinorMatrices.length;i++){
            for(int j=0;j<determinantForMinorMatrices[i].length;j++){
                System.out.print(determinantForMinorMatrices[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private static void printMatrix(Factor[][] determinantForMinorMatrices) {

        for(int i=0;i<determinantForMinorMatrices.length;i++){
            for(int j=0;j<determinantForMinorMatrices[i].length;j++){
                System.out.print(determinantForMinorMatrices[i][j].numerator +"/"+determinantForMinorMatrices[i][j].denominator+"\t");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[][] m) {

        ArrayList<int[]> terminalStatesList=new ArrayList<>();
        ArrayList<int[]> nonTerminalStatesList=new ArrayList<>();
        HashMap<Integer,Integer> denominatorMap=new HashMap<>();

        int[] r=new int[2];
        if(m[0][0]==0 && m.length==1)
        {
            r[0]=1;
            r[1]=1;
            return r;
        }

        for(int i = 0; i < m.length; i++){
            boolean isTerminal = true;
            int sum = 0;
            for(int j = 0; j < m[0].length; j++){
                sum += m[i][j];
                if(m[i][j] != 0){
                    isTerminal = false;
                }
            }

            if(isTerminal){
                terminalStatesList.add(m[i]);
            }else{
                nonTerminalStatesList.add(m[i]);
                denominatorMap.put(i,sum);
            }
        }

        int[][] terminalStates = new int[terminalStatesList.size()][m.length];
        int[][] nonTerminalStates = new int[nonTerminalStatesList.size()][m.length];
        for(int i = 0; i < terminalStatesList.size(); i++){
            terminalStates[i] = terminalStatesList.get(i);
        }
        for(int i = 0; i < nonTerminalStatesList.size(); i++){
            nonTerminalStates[i] = nonTerminalStatesList.get(i);
        }
        
       Factor[][] IMatrix= getIMatrix(nonTerminalStates.length);
       Factor[][] QMatrix= getQMatrix(nonTerminalStates,denominatorMap );
       Factor[][] RMatrix= getRMatrix(nonTerminalStates,terminalStates.length,denominatorMap);
       Factor[][] IMinusQMatrix=subtractMatrices(IMatrix,QMatrix);
       Factor[][] FMatrix=getInverse(IMinusQMatrix);
       
       Factor[][] FRMatrix=multiplyMatrices(FMatrix,RMatrix);

       Factor[] rawAns=FRMatrix[0];
        int[] denomList = new int[rawAns.length];
        Factor[] numeratorList=new Factor[rawAns.length];
        for (int i = 0; i < rawAns.length; i++) {
            denomList[i] = rawAns[i].denominator;
            numeratorList[i]=rawAns[i];
        }

        int lcm=getLcm(denomList);
        int []ans=new int[rawAns.length+1];

        for(int i=0;i<rawAns.length;i++){
            ans[i]=numeratorList[i].multiply(new Factor(lcm)).numerator;
            ans[i]/=numeratorList[i].denominator;
        }
        ans[ans.length-1]=lcm;
        return ans;
    }

    private static Factor[][] multiplyMatrices(Factor[][] fMatrix, Factor[][] rMatrix) {
        Factor[][] ans=new Factor[fMatrix.length][rMatrix[0].length];
        for (int i = 0; i < fMatrix.length; i++) {
            for (int j = 0; j < rMatrix[0].length; j++) {
                Factor product=new Factor(0,1);
                for (int k = 0; k < fMatrix[0].length; k++) {
                    // product[i][j] += matrix[i][k] * mat.getElement(k, j);
                   Factor temp= fMatrix[i][k].multiply(rMatrix[k][j]);
                product= product.add(temp);
                }
                ans[i][j]=product;
            }
        }

        return ans;
    }

    private static Factor[][] subtractMatrices(Factor[][] iMatrix, Factor[][] qMatrix) {
        Factor[][] ans=new Factor[iMatrix.length][iMatrix.length];
        for(int i=0;i<iMatrix.length;i++){
            for(int j=0;j<iMatrix[i].length;j++){
               ans[i][j]= iMatrix[i][j].subtract(qMatrix[i][j]);
            }
        }
        return ans;
                
    }

    private static Factor[][] getRMatrix(int[][] nonTerminalStates,int terminalLength,HashMap<Integer,Integer> map) {
        Factor[][] ans=new Factor[nonTerminalStates.length][terminalLength];
        
        for(int i=0;i<nonTerminalStates.length;i++){
            for(int j=nonTerminalStates.length;j<nonTerminalStates[i].length;j++){
                ans[i][j-nonTerminalStates.length]=new Factor(nonTerminalStates[i][j],map.get(i));
            }
        }
        return ans;
    }

    private static Factor[][] getQMatrix(int[][] nonTerminalStates,HashMap<Integer,Integer> map) {
        int length=nonTerminalStates.length;
        Factor[][] ans=new Factor[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                ans[i][j]=new Factor(nonTerminalStates[i][j],map.get(i));
            }
        }
        return ans;
    }


    static Factor[][] getIMatrix(int size){
        Factor[][] ans=new Factor[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                
                if(i==j){
                    ans[i][j]=new Factor(1,1);
                }else {
                    ans[i][j]=new Factor(0,1);
                }
            }
        }
        
        return ans;
    }


//   int[][] findInverse(int[][] matrix){
//
//   }


//    static int findAdjoint(int[][] matrix){
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix.length;j++){
//
//                HashSet<Integer> set=new HashSet<>();
//                set.add(j);
//            }
//        }
//    }

    public static int getLcm(int arr[]) {
        int max = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int res = 1;
        int factor = 2;
        while (factor <= max) {
            ArrayList<Integer> arrIndex = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if (arr[j] % factor == 0) {
                    arrIndex.add(arrIndex.size(), j);
                }
            }
            if (arrIndex.size() >= 2) {
                // Reduce all array elements divisible
                // by factor.
                for (int j = 0; j < arrIndex.size(); j++) {
                    arr[arrIndex.get(j)] /= factor;
                }

                res *= factor;
            } else {
                factor++;
            }
        }

        // Then multiply all reduced array elements
        for (int i = 0; i < n; i++) {
            res *= arr[i];
        }

        return res;
    }


    static Factor[][] getInverse(Factor[][] matrix){

       Factor[][] adjoint= getAdjoint(matrix);
        Factor determinant=findDeterminant(matrix);

        Factor[][] factors=new Factor[adjoint.length][adjoint[0].length];

        for(int i=0;i<factors.length;i++){
            for(int j=0;j<factors[i].length;j++)
           // factors[i][j]=new Factor(adjoint[i][j],determinant);
            factors[i][j]=adjoint[i][j].divide(determinant);
        }


        return factors;


    }

    static Factor[][] getAdjoint(Factor[][] matrix){

       Factor[][] minorDeterminants= findDeterminantForMinorMatrices(matrix);
       Factor [][] transpose=new Factor[minorDeterminants.length][minorDeterminants[0].length];

       for(int i=0;i<transpose.length;i++){
           for(int j=0;j<transpose[i].length;j++){
               Factor t=new Factor(0,1);
               t.numerator=(int) (Math.pow(-1,i+j)*minorDeterminants[j][i].numerator);
               t.denominator=minorDeterminants[j][i].denominator;
               transpose[i][j]=t;
           }
       }

      return transpose;
    }

    static Factor[][] findDeterminantForMinorMatrices(Factor[][] matrix){
        Factor[][] minorDetMatrix=new Factor[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                Set<Integer> rowExclusions=new HashSet<>();
                rowExclusions.add(i);
                Set<Integer> columnExclusions=new HashSet<>();
                columnExclusions.add(j);
                minorDetMatrix[i][j]=findDeterminantForMinorMatrices(matrix,rowExclusions,columnExclusions);
            }
        }
        return minorDetMatrix;

    }

    static Factor findDeterminantForMinorMatrices(Factor [][] matrix, Set<Integer> rowExclusions,Set<Integer> columnExclusions){
        if(matrix.length-rowExclusions.size()==2){
            Integer col1=null;
            Integer col2=null;
            Integer row1=null;
            Integer row2=null;


            for(int i=0;i<matrix.length;i++){
                if(!rowExclusions.contains(i)){

                    if(row1==null){
                        row1=i;
                    }else {
                        row2=i;
                    }
                }
            }
            for(int i=0;i<matrix.length;i++){
                if(!columnExclusions.contains(i)){

                    if(col1==null){
                        col1=i;
                    }else {
                        col2=i;
                    }
                }
            }

            Factor det=matrix[row1][col1].multiply(matrix[row2][col2]).subtract(matrix[row1][col2].multiply(matrix[row2][col1]));
            return det;

        }else if(matrix.length-rowExclusions.size()<2){
            Integer col1=null;
            Integer row1=null;


            for(int i=0;i<matrix.length;i++){
                if(!rowExclusions.contains(i)){

                    if(row1==null){
                        row1=i;
                    }
                }
            }
            for(int i=0;i<matrix.length;i++){
                if(!columnExclusions.contains(i)){

                    if(col1==null){
                        col1=i;
                    }
                }
            }

            Factor det=matrix[row1][col1];
            return det;

        }
        else if((matrix.length-rowExclusions.size())>2){
            Factor ans=new Factor(0,1);

            for(int i=0;i<matrix.length;i++) {
                if(!rowExclusions.contains(i)) {
                    int rowId=i;
                    rowExclusions.add(i);
                    int sign = 1;
                    Factor signFactor=new Factor(sign,1);
                    for (int j = 0; j < matrix.length; j++) {
                        if (!columnExclusions.contains(j)) {
                            Factor r = matrix[rowId][j];
                            //exlusions.add(rowId);
                            columnExclusions.add(j);
                            Factor temp = r.multiply (findDeterminantForMinorMatrices(matrix, rowExclusions, columnExclusions));
                            ans.add( signFactor .multiply(temp));
                            sign=-sign;
                            signFactor = new Factor(sign,1);
                            // exlusions.remove(rowId);
                            columnExclusions.remove(j);
                        }

                    }
                    rowExclusions.remove(i);
                }
            }
            return ans;

        }
        return new Factor(0,1);
    }

   static Factor findDeterminant(Factor[][] matrix){
        return findDeterminant(matrix,matrix.length,new HashSet<>());
   }

   static Factor findDeterminant(Factor [][] matrix, int length, Set<Integer> exlusions){
        if(length==2){
            Integer col1=null;
            Integer col2=null;

            for(int i=0;i<matrix.length;i++){
                if(!exlusions.contains(i)){

                    if(col1==null){
                        col1=i;
                    }else {
                        col2=i;
                    }
                }
            }
            int row1=matrix.length-2;
            int row2=matrix.length-1;

          //  int det=matrix[row1][col1]*matrix[row2][col2]-matrix[row1][col2]*matrix[row2][col1];
            Factor det=matrix[row1][col1].multiply(matrix[row2][col2]).subtract(matrix[row1][col2].multiply(matrix[row2][col1]));

            return det;

        }
        else if(length>2){
            Factor ans=new Factor(0,1);
           int rowId= matrix.length-length;
           int sign=1;
           Factor signFactor=new Factor(sign,1);
           for(int j=0;j<matrix.length;j++) {
               if (!exlusions.contains(j)) {
                   Factor r = matrix[rowId][j];
                   //exlusions.add(rowId);
                   exlusions.add(j);
                   Factor temp = r.multiply (findDeterminant(matrix, length - 1, exlusions));
                   ans.add(signFactor .multiply( temp));
                   sign = -sign;
                   signFactor=new Factor(sign,1);
                   // exlusions.remove(rowId);
                   exlusions.remove(j);
               }
           }
           return ans;

        }
        return new Factor(0,1);
   }


   static class Factor{

        int numerator;
        int denominator;

        Factor(int numerator){
            this.numerator=numerator;
            this.denominator=1;
        }

        Factor(int numerator,int denominator){
            this.numerator=numerator;
            this.denominator=denominator;
            simplify();
            checkSign(this);
        }

       private int getGcm(int num1, int num2) {
           return num2 == 0 ? num1 : this.getGcm(num2, num1 % num2);
       }

       // Simplify fraction to simplest form, runs in constructor
       public void simplify() {
          // this.sign = !(this.numerator <= 0 && this.denominator <= 0) && !(this.numerator >= 0 && this.denominator >= 0);

          // this.numerator = Math.abs(this.numerator);
          // this.denominator = Math.abs(this.denominator);

           int gcm = this.getGcm(Math.abs(this.numerator), Math.abs(this.denominator));
           this.numerator = this.numerator / gcm;
           this.denominator = this.denominator / gcm;

           if(this.numerator<0 && this.denominator<0){
               this.numerator= -this.numerator;
               this.denominator= -this.denominator;
           }
           // When fraction is zero, make sure denominator is one and no negative sign
           if (this.numerator == 0 && this.denominator != 0) {
               this.denominator = 1;
             //  this.sign = false;
           }
       }

       public Factor subtract(Factor f) {
            Factor ans=new Factor(1,1);
            if(this.numerator==0){
                ans.numerator=-f.numerator;
                ans.denominator=f.denominator;
            }else if(f.numerator==0){
                ans.numerator=this.numerator;
                ans.denominator=this.denominator;
            }else {

                ans.numerator = this.numerator * f.denominator - f.numerator * this.denominator;
                ans.denominator = this.denominator * f.denominator;
            }
            checkSign(ans);
            ans.simplify();
            return ans;
            
       }

       public Factor multiply(Factor f) {
            Factor ans=new Factor(1,1);
            ans.numerator=this.numerator*f.numerator;
            ans.denominator=this.denominator*f.denominator;
            checkSign(ans);
            return ans;
       }
       
       public Factor add(Factor f){
           Factor ans=new Factor(1,1);
           if(this.numerator==0){
               ans.numerator=f.numerator;
               ans.denominator=f.denominator;
           }else if(f.numerator==0){
               ans.numerator=this.numerator;
               ans.denominator=this.denominator;
           }else {
               ans.numerator = this.numerator * f.denominator + f.numerator * this.denominator;
               ans.denominator = this.denominator*f.denominator;
           }
           checkSign(ans);
           ans.simplify();
           return ans;
            
       }
       
       public void checkSign(Factor f){
            if(f.numerator<0 && f.denominator <0){
                f.numerator= -f.numerator;
                f.denominator= -f.denominator;
            }
       }

       public Factor divide(Factor f) {
           Factor ans=new Factor(this.numerator * f.denominator, this.denominator * f.numerator);
           checkSign(ans);
           return ans;
       }
   }

}
