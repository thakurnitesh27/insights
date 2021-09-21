package algo.arrays;

import java.util.ArrayList;

public class PascalTriangle {

    /*
    [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     */
    public static void main(String[] args) {

        print(new PascalTriangle().solve(0));
    }

    private int[][] solve(int A){
        int response[][]=new int[A][];
        if(A==0){
            return response;
        }
        int i=A-1;
        for(int j=A;j>0;j--){
            response[i]=new int[j];
            i--;
        }

        response[0][0]=1;
        int k=0;
        for( i=1;i<response.length;i++){
            for(k=0;k<response[i].length;k++)

                if(k>0 && k<response[i].length-1){
                    response[i][k]=response[i-1][k-1]+response[i-1][k];
                }
                else {
                    response[i][k]=1;
                }

        }
return response;

    }

    private static void print(int[][] A){

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}
