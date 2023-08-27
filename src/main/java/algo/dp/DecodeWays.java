package algo.dp;
//https://leetcode.com/problems/decode-ways
public class DecodeWays {

    public static void main(String[] args) {

//        System.out.println(new DecodeWays().numDecodings("12"));
//        System.out.println(new DecodeWays().numDecodings("226"));
//        System.out.println(new DecodeWays().numDecodings("06"));
//        System.out.println(new DecodeWays().numDecodings("11106"));
        System.out.println(new DecodeWays().numDecodings("2110222"));
        System.out.println(new DecodeWays().numDecodings("2110262"));
        System.out.println(new DecodeWays().numDecodings("4110262"));
        System.out.println(new DecodeWays().numDecodings("411022"));
    }

    public int numDecodings(String s) {

        int[] nums = new int[s.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        int[] dp = new int[nums.length];

        dp[dp.length - 1] = nums[nums.length-1]==0?0:1;

        for (int i = dp.length - 2; i >= 0; i--) {

            if (nums[i] == 0) {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
//           if(i+1<dp.length && nums[i+1]==0){
////               dp[i]+=1;
////               continue;
////           }
//            if (i + 2 < dp.length) {
//                dp[i] += dp[i + 2];
//            }
            if (nums[i] <= 2) {
                if (i + 2 < dp.length) {
                    dp[i] += dp[i + 2];
                } else
                    dp[i] += 1;
            }


        }

        return dp[0];

    }
}
