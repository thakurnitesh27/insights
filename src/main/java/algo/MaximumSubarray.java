package algo;
//https://leetcode.com/problems/maximum-subarray/?envType=featured-list&envId=top-interview-questions
public class MaximumSubarray {

    public static void main(String[] args) {
        new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;

        int wl=0,wr=1;
        int sum=nums[0];
        int ans=Integer.MIN_VALUE;

        while (wr<nums.length){

            if(sum+nums[wr]<0){
                sum=0;
                wr++;
                wl=wr;
            }
            else {
                sum+=nums[wr];
                wr++;
            }
            ans=Math.max(sum,ans);
           // wr++;
        }

        return ans;

    }


}
