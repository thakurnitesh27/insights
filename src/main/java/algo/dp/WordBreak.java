package algo.dp;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreakBottomUp("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new WordBreak().wordBreakBottomUp("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new WordBreak().wordBreakBottomUp("catsandog", Arrays.asList("cats", "dog","sand","and","cat")));
    }

    public boolean wordBreakBottomUp(String s, List<String> wordDict) {

            boolean [] dp=new boolean[s.length()+1];
            dp[dp.length-1]=true;
            for(int i=s.length()-1;i>=0;i--){

                for(int j=i;j<dp.length;j++){

                    if(dp[j] && wordDict.contains(s.substring(i,j))){
                        dp[i]=true;
                        break;
                    }
                }
            }
            return dp[0];
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[][] dp = new Boolean[s.length() + 1][s.length() + 1];

        return find(0, s.length(), wordDict, dp, s);


    }

    boolean find(int startIndex, int endIndex, List<String> wordDict, Boolean[][] dp, String s) {

        if (startIndex > endIndex || endIndex < 0) {
            return false;
        }
        if (dp[startIndex][endIndex] != null) {
            return dp[startIndex][endIndex];
        }
        String temp = s.substring(startIndex, endIndex);
        if (wordDict.contains(temp)) {
            dp[startIndex][endIndex] = true;
            return true;
        }

        boolean ans = false;
        for (int i = startIndex + 1; i <= endIndex; i++) {

            boolean currentAns = find(i, endIndex, wordDict, dp, s);
            if (currentAns) {
                currentAns = find(startIndex, i, wordDict, dp, s);
            }
            ans= ans || currentAns;

        }
        dp[startIndex][endIndex] = ans;
        return ans;

    }
}
