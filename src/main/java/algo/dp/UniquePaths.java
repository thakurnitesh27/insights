package algo.dp;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(new UniquePaths().uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=0;
        dp[1][0]=1;
        dp[0][1]=1;
        return findCount(m-1,n-1,m,n,dp);

    }
    int findCount(int x, int y, int xLimit, int yLimit, int[][]dp){

        if(x<0 || y<0){
            return 0;
        }

        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        int count1=0,count2=0;
        if(x>=0){
            count1= findCount(x-1,y,xLimit,yLimit,dp);
        }
        if(y>=0){
            count2=findCount(x,y-1,xLimit,yLimit,dp);
        }

        dp[x][y]=count1+count2;

        return dp[x][y];
    }
}
