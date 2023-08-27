package algo.dp;

import java.util.Arrays;

//https://leetcode.com/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
public class LongestPalindromicSubString {

    public static void main(String[] args) {

          System.out.println(new LongestPalindromicSubString().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubString().longestPalindrome("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 0;
        }

        find(s, 0, s.length() - 1, dp);

        String ans = "";
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {

                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;


    }

    int find(String s, int startIndex, int endIndex, int[][] dp) {

        if (startIndex <= endIndex) {

            if (dp[startIndex][endIndex] != -1) {
                return dp[startIndex][endIndex];

            }
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                if (endIndex - startIndex <= 2) {
                    dp[startIndex][endIndex] = endIndex - startIndex + 1;
                    return dp[startIndex][endIndex];
                }
                int palindromeExists = find(s, startIndex + 1, endIndex - 1, dp);

                if (palindromeExists != 0) {
                    dp[startIndex][endIndex] = endIndex - startIndex + 1;
                    return dp[startIndex][endIndex];
                }
            }

            find(s, startIndex + 1, endIndex, dp);
            find(s, startIndex, endIndex - 1, dp);
            dp[startIndex][endIndex] = 0;
            return 0;

        }

        return 0;
    }
}
