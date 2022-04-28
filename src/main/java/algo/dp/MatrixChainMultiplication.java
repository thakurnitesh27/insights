package algo.dp;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        //Taken from Cormen
        int arr[]=new int[]{30,35,15,5,10,20,25};
        System.out.println(new MatrixChainMultiplication().findMinimumOrder(arr));
    }

    int[][] findMinimumOrder(int[]arr){

        int length=arr.length-1;

        int[][]m=new int[length+1][length+1];
        int[][]s=new int[length+1][length+1];

        for(int i=0;i<length;i++){
            m[i][i]=0;
        }

        for(int l=2;l<=length;l++){

            for(int i=1; i<=length-l+1;i++){

                int j=i+l-1;
                int q=Integer.MAX_VALUE;

                for(int k=i;k<=j-1;k++){
                    int tmp=m[i][k]+m[k+1][j]+arr[i-1]*arr[k]*arr[j];

                    if(tmp<q){
                        q=tmp;
                        m[i][j]=q;
                        s[i][j]=k;
                 }

                }

            }
        }

        return s;
    }
}
