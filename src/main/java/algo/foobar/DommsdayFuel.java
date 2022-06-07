package algo.foobar;

import java.util.HashSet;
import java.util.Set;

import static jdk.nashorn.internal.objects.Global.print;

public class DommsdayFuel {

    public static void main(String[] args) {
        int[][] arr =new int[][]{
                {0,1,0,0,1,0},
                {4,0,0,3,2,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
       // System.out.println(solution(arr));

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
        printMatrix(getInverse(arr));
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
        // Your code here
        return null;
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


    static Factor[][] getInverse(int[][] matrix){

       int[][] adjoint= getAdjoint(matrix);
        int determinant=findDeterminant(matrix);

        Factor[][] factors=new Factor[adjoint.length][adjoint[0].length];

        for(int i=0;i<factors.length;i++){
            for(int j=0;j<factors[i].length;j++)
            factors[i][j]=new Factor(adjoint[i][j],determinant);
        }


        return factors;


    }

    static int[][] getAdjoint(int[][] matrix){

       int[][] minorDeterminants= findDeterminantForMinorMatrices(matrix);
       int [][] transpose=new int[minorDeterminants.length][minorDeterminants[0].length];

       for(int i=0;i<transpose.length;i++){
           for(int j=0;j<transpose[i].length;j++){
               transpose[i][j]= (int) (Math.pow(-1,i+j)*minorDeterminants[j][i]);
           }
       }

      return transpose;
    }

    static int[][] findDeterminantForMinorMatrices(int[][] matrix){
        int[][] minorDetMatrix=new int[matrix.length][matrix[0].length];

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

    static int findDeterminantForMinorMatrices(int [][] matrix, Set<Integer> rowExclusions,Set<Integer> columnExclusions){
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

            int det=matrix[row1][col1]*matrix[row2][col2]-matrix[row1][col2]*matrix[row2][col1];
            return det;

        }
        else if((matrix.length-rowExclusions.size())>2){
            int ans=0;

            for(int i=0;i<matrix.length;i++) {
                if(!rowExclusions.contains(i)) {
                    int rowId=i;
                    rowExclusions.add(i);
                    int sign = 1;
                    for (int j = 0; j < matrix.length; j++) {
                        if (!columnExclusions.contains(j)) {
                            int r = matrix[rowId][j];
                            //exlusions.add(rowId);
                            columnExclusions.add(j);
                            int temp = r * (findDeterminantForMinorMatrices(matrix, rowExclusions, columnExclusions));
                            ans += sign * temp;
                            sign = -sign;
                            // exlusions.remove(rowId);
                            columnExclusions.remove(j);
                        }

                    }
                    rowExclusions.remove(i);
                }
            }
            return ans;

        }
        return 1;
    }

   static int findDeterminant(int[][] matrix){
        return findDeterminant(matrix,matrix.length,new HashSet<>());
   }

   static int findDeterminant(int [][] matrix, int length, Set<Integer> exlusions){
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

            int det=matrix[row1][col1]*matrix[row2][col2]-matrix[row1][col2]*matrix[row2][col1];
            return det;

        }
        else if(length>2){
            int ans=0;
           int rowId= matrix.length-length;
           int sign=1;
           for(int j=0;j<matrix.length;j++) {
               if (!exlusions.contains(j)) {
                   int r = matrix[rowId][j];
                   //exlusions.add(rowId);
                   exlusions.add(j);
                   int temp = r * (findDeterminant(matrix, length - 1, exlusions));
                   ans += sign * temp;
                   sign = -sign;
                   // exlusions.remove(rowId);
                   exlusions.remove(j);
               }
           }
           return ans;

        }
        return 1;
   }


   static class Factor{

        int numerator;
        int denominator;

        Factor(int numerator,int denominator){
            this.numerator=numerator;
            this.denominator=denominator;
            simplify();
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
   }

}
