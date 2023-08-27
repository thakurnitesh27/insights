package algo.dp;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {

        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1, 3, 1},
                {1, 5, 1}, {4, 2, 1}}));

    }

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = grid[0][0];
        find(grid.length - 1, grid[0].length - 1,  grid, dp);
        return dp[grid.length - 1][grid[0].length - 1];

    }

    int find(int i, int j, int[][] grid, int[][] dp) {

        if (i >= 0 && j >= 0) {

            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int ans = Integer.MAX_VALUE;

           // int newSum =  grid[i][j];
            if(i>0) {
                int a = find(i - 1, j, grid, dp);
                ans = Math.min(a, ans);
            }

            if(j>0) {
                int b = find(i, j - 1, grid, dp);
                ans = Math.min(b, ans);
            }


            dp[i][j] = ans+grid[i][j];
            return  ans+grid[i][j];

        }
        return Integer.MAX_VALUE;
    }
}
