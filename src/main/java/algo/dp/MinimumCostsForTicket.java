package algo.dp;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-cost-for-tickets/description/
public class MinimumCostsForTicket {
    public static void main(String[] args) {

        System.out.println(new MinimumCostsForTicket().minCostTicketsOptimal(new int[]{1,4,6,7,8,20},new int[]{2,7,15}));

    }

    public int minCostTicketsOptimal(int[] days, int[] costs){
        TreeSet<Integer> dates = new TreeSet<>();
        for (int i = 0; i < days.length; i++) {
            dates.add(days[i]);
        }

        int maxDate = dates.last();
        int[] dp = new int[maxDate + 1];
        int j=2;

        // for (int j = 0; j < costs.length; j++) {

        for (int i = 1; i <= maxDate; i++) {

            if (dates.contains(i)) {
                int  monthWise=Math.min(
                        dp[Math.max(i-30,0)]+costs[j],
                        Math.min(
                                dp[Math.max(i-7,0)]+costs[j-1],dp[i-1]+costs[j-2]));

                dp[i] = monthWise;


            } else {
                dp[i] = dp[i-1];
            }

        }
        //  }

        return dp[dp.length-1];
    }

    public int mincostTickets(int[] days, int[] costs) {

        TreeSet<Integer> dates = new TreeSet<>();
        for (int i = 0; i < days.length; i++) {
            dates.add(days[i]);
        }

        int maxDate = dates.last();
        int[][] dp = new int[costs.length][maxDate + 1];


        for (int j = 0; j < costs.length; j++) {

            for (int i = 0; i <= maxDate; i++) {
                if (i == 0) {
                    dp[j][i] = 0;
                    continue;
                }
                if (dates.contains(i)) {

                    if (j == 0) { //each day
                        dp[j][i] = dp[j][i-1] + costs[j];
                    } else if (j == 1) { //each week

                        int weekWise =costs[j];
                        if(i>7){

                            weekWise=Math.min(dp[j][i-7]+costs[j],dp[j][i-1]+costs[j-1]);
                        }
                        int result = Math.min(weekWise, dp[j - 1][i]);
                        dp[j][i] = result;
                    } else if (j == 2) { //each month
                        int monthWise =costs[j];
                        if(i>30){
                            monthWise=Math.min(dp[j][i-30]+costs[j],Math.min(dp[j][i-7]+costs[j-1],dp[j][i-1]+costs[j-2]));
                        }
                        int result = Math.min(monthWise, dp[j -1][i]);

                        dp[j][i] = result;
                    }

                } else {
                    dp[j][i] = dp[j][i-1];
                }

            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
