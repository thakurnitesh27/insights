package algo.dp;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePath2 {

    public static void main(String[] args) {

        System.out.println(new UniquePath2().uniquePathsWithObstacles(new int[][]
                {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }
        ));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][]dp =new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=0;

        if(dp.length>1)
        {
            dp[1][0]=1;
        }

        if(dp[0].length>1){
            dp[0][1]=1;
        }
        return findCount(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,dp);


    }


    int findCount(int x, int y, int[][] nums, int[][]dp){
        if(x<0 ||y<0){
            return 0;
        }
        if(nums[x][y]==1){
            dp[x][y]=0;
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        int count1=findCount(x-1,y,nums,dp);
        int count2=findCount(x,y-1,nums,dp);

        dp[x][y]=count1+count2;

        return dp[x][y];
    }
}
