package algo.dp;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/
public class MinimumPathCostInGrid {

    public static void main(String[] args) {

        System.out.println(new MinimumPathCostInGrid().minPathCost(new int[][]{
                {5,3},{4,0},{2,1}
        },new int[][]{
                {9,8},{1,5},{10,12},{18,6},{2,4},{14,3}
        }));
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {

        int[][] dp=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length-1;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<grid[0].length;i++){
            dp[dp.length-1][i]=grid[grid.length-1][i];
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
           min=Math.min(min, find(0,i,grid,moveCost,dp));
        }

        return min;

    }

    int find(int i,int j, int[][] grid, int[][] cost,int[][] dp){

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int [] numCost=   cost[grid[i][j]];
        int min=Integer.MAX_VALUE;

        for(int k=0;k<grid[0].length;k++){

         int b= numCost[k]+ find(i+1,k,grid,cost,dp);
            min=Integer.min(min,b);
        }
        int ans=min+grid[i][j];

        dp[i][j]=ans;
        return ans;
    }
}
