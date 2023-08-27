package algo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
public class CoinChange {

    public static void main(String[] args) {
      //  System.out.println(new CoinChange().coinChange(new int[]{1,2147483647},2));
        System.out.println(new CoinChange().coinChangeDPNew(new int[]{186,419,83,408},6249));
        System.out.println(new CoinChange().coinChangeDPNew(new int[]{1,3,7},5));
        System.out.println(new CoinChange().coinChangeDPNew(new int[]{1,2,3,9},25));
        System.out.println(new CoinChange().coinChangeDPNew(new int[]{1,2,5},11));
        System.out.println(new CoinChange().coinChangeDPNew(new int[]{2},3));
        System.out.println(new CoinChange().coinChangeDP(new int[]{1},0));
    }

    public int coinChangeDPNew(int[] coins,int amount){

        Arrays.sort(coins);

        int [][] dp=new int[coins.length][amount+1];

        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0]=0;
        }



        for(int i=0;i<coins.length;i++){

            for(int j=1;j<=amount;j++){

                if(coins[i]>j && i>0 && dp[i-1][j]>=0){
                    dp[i][j]=dp[i-1][j];
                }
                else if(coins[i]<=j){
                    int newAmount=j-coins[i];
                    int count= (dp[i][newAmount]<0?-1:dp[i][newAmount]+1);

                    if(i>0){
                        if(dp[i-1][j]!=-1) {
                            count = count > 0 ? Math.min(count, dp[i - 1][j]) : dp[i-1][j];
                        }

                    }

                    dp[i][j]=count;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];


    }

    public int coinChangeDP(int[] coins,int amount){

       Map<Integer,Integer> map=new HashMap<>();

       return coinChange(coins,amount,map);
    }

    int coinChange(int[] coins, int amount, Map<Integer,Integer> map){

        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(map.get(amount)!=null){
            return map.get(amount);
        }

        int cc=-1;

        for(int i=0;i<coins.length;i++){
            int coin=coinChange(coins,amount-coins[i],map);
            if(coin>=0){
               cc= cc<0?coin+1:Math.min(cc,coin+1);
            }
        }
        map.put(amount,cc);
        return cc;

    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int i=coins.length-1;
        while (i>=0) {
           int ans= findCount(0, i, coins, amount, 0);
           if(ans==-1 && amount>=coins[i]){
               i--;
           }
           else return ans;
        }
        return -1;

    }

    private int findCount(int startIndex, int endIndex, int[] coins, int amount, int count) {
        if(endIndex<0 || startIndex>endIndex){
            return -1;
        }

        if (amount >= coins[endIndex]) {
            count+= amount / coins[endIndex];
            amount = amount % coins[endIndex];
            if(amount==0){
                return count;
            }
            return findCount(startIndex, endIndex - 1, coins, amount, count);
        }

        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if (coins[mid] == amount) {
                return count + 1;
            } else if (coins[mid] < amount) {
                if(mid+1<coins.length && coins[mid+1]>amount ){
                    count+= amount / coins[mid];
                    amount = amount % coins[mid];
                    if(amount==0){
                        return count;
                    }
                    return findCount(startIndex, mid, coins, amount, count);
                }
                return findCount(mid, endIndex, coins, amount, count);
            } else {
                return findCount(startIndex, mid, coins, amount, count);
            }
        } else if (startIndex >= 0 && startIndex < coins.length && startIndex == endIndex) {
            if (coins[startIndex] <= amount) {
                count += (amount / coins[startIndex]);
                amount = amount % coins[startIndex];
                if (amount == 0) {
                    return count;
                }
                return findCount(0, startIndex, coins, amount, count);
            } else {
                return -1;
            }
        } else return -1;

    }
}
