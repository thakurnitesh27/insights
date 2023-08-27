package algo.dp;
//https://leetcode.com/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-interview-150
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

    public int lengthOfLIS(int[] nums) {

        int [] dp=new int[nums.length];
        dp[nums.length-1]=1;

        int max=0;

        for(int i=dp.length-2;i>=0;i--){

            int value=1;

            for(int j=i+1;j<dp.length;j++){
                if(nums[i]<nums[j]){
                    value=Math.max(value,dp[j]+1);
                }
            }
            dp[i]=value;
            max=Math.max(max,value);
        }

        return max;
    }
}
