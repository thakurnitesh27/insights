package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=top-interview-150
public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> list=new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(new Triangle().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp= new int[triangle.size()][triangle.size()];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<triangle.size();i++){
            dp[triangle.size()-1][i]=triangle.get(triangle.size()-1).get(i);
        }
       int ans= find(0,0,dp,triangle);
        return dp[0][0];
    }

    int find(int i,int j,int[][] dp, List<List<Integer>> triangle){
        if(i<dp.length && j<i+1){

            if(dp[i][j]!=-1){
                return dp[i][j];
            }

           int a= find(i+1,j,dp,triangle);
            int b=find(i+1,j+1,dp,triangle);
            int ans=Math.min(a,b);
            ans+=triangle.get(i).get(j);
            dp[i][j]=ans;
            return ans;
        }
        return Integer.MAX_VALUE;

    }
}
