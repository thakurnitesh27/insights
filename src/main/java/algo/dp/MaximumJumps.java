package algo.dp;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
public class MaximumJumps {

    public static void main(String[] args) {

        System.out.println(new MaximumJumps().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
        System.out.println(new MaximumJumps().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
        System.out.println(new MaximumJumps().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
        System.out.println(new MaximumJumps().maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 1));
    }


    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        dp[dp.length - 1] = 0;


        for (int i = dp.length - 2; i >= 0; i--) {

            int max = -1;

            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        return dp[0];
    }
}
