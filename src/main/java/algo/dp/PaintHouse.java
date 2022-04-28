package algo.dp;

public class PaintHouse {

    public static void main(String[] args) {

        int[][]arr=new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minimumCost(arr));
        arr=new int[][]{{17,2,2},{16,3,1},{14,3,2}};
        System.out.println(minimumCost(arr));
        arr=new int[][]{{17,6,2}};
        System.out.println(minimumCost(arr));

    }

   static int minimumCost(int[][]costs){
        int [][] dp=new int[3][costs.length];
        dp[0][costs.length-1]=costs[costs.length-1][0];
        dp[1][costs.length-1]=costs[costs.length-1][1];
        dp[2][costs.length-1]=costs[costs.length-1][2];

        for(int i=costs.length-2;i>=0;i--){
            dp[0][i]=costs[i][0]+Math.min(dp[1][i+1],dp[2][i+1]);
            dp[1][i]=costs[i][1]+Math.min(dp[0][i+1],dp[2][i+1]);
            dp[2][i]=costs[i][2]+Math.min(dp[1][i+1],dp[0][i+1]);

        }

        int ans=Math.min(dp[0][0],Math.min(dp[1][0],dp[2][0]));
        return ans;
    }
}
