package algo.dp;

//https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/1862527/Python-DP-Explained-in-comments
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,15,7,9,2,5,10};
        System.out.println(new PartitionArrayForMaximumSum().findMaximumSum(arr,3));
    }

    int findMaximumSum(int[] arr,int k){
        int []dp=new int[arr.length+1];

        for(int i=1;i<=arr.length;i++){
            int max=0;
            int val=0;

            for(int j=1;j<=Math.min(i,k);j++){
                max=Math.max(max,arr[i-j]);
                val=Math.max(dp[i-j]+max*(j),val);
            }

            dp[i]=val;
        }

        return dp[arr.length];

    }

}
