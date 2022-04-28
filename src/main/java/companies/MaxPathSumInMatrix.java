package companies;

//https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998
public class MaxPathSumInMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        arr=new int[][]{
                {-10000}
        };

        System.out.println(getMaxPathSum(arr));
        arr=new int[][]{
                {-9999 ,-9888 ,-9777, -9666, -9555}
        };

        System.out.println(getMaxPathSum(arr));
        arr=new int[][]{
                {-9999 ,-9888 ,-9777, -9666, -9555},

                {1 ,10, 2, 4, 5},
                { -9999, -9888, -9777, -9666, -9555},
                {0, 0, 0 ,0 ,0},
                {-99 ,-98, -97, -96, -95}
        };

        System.out.println(getMaxPathSum(arr));
        arr=new int[][]{
                { 1 ,0, 0, 0, 0},
                { 0, 1, 0, 0, 0},
                { 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(getMaxPathSum(arr));
        arr=new int[][]{
                { -1 ,0, 0, 0, 0},
                { 0, -1, 0, 0, 0},
                { 0, 0, -1, 0, 0},
                {0, 0, 0, -1, 0},
                {0, 0, 0, 0, -1}
        };

        System.out.println(getMaxPathSum(arr));
    }

    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int max=Integer.MIN_VALUE;
        int[][]dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            max=Math.max(max,findMax(matrix,0,i,dp));
        }

        return max;

    }
    static int findMax(int[][] matrix,int i, int j,int[][] dp){
        if(i<matrix.length){
            if(dp[i][j]!=Integer.MIN_VALUE){
                return dp[i][j];
            }
            int ans1=Integer.MIN_VALUE,ans2=Integer.MIN_VALUE,ans3=Integer.MIN_VALUE;
            if(j>0){
                ans1=findMax(matrix,i+1,j-1,dp);
            }
            ans2=findMax(matrix,i+1,j,dp);
            if(j<matrix[i].length-1){
                ans3=findMax(matrix,i+1,j+1,dp);
            }

//            System.out.println("Found ans1: "+ans1+
//                    " ans2: "+ans2+" ans3: "+ans3);

            int ans= matrix[i][j] + (Math.max(ans1,Math.max(ans2,ans3)));
          //  System.out.println("Ans is: "+ans);
            dp[i][j]=ans;
            return ans;
        }

        return 0;
    }
}
