package algo.dp;
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String[] args) {
        int [] arr=new int[]{2,7,9,3,1};
        System.out.println(robHouse(arr));
        int [] arr1=new int[]{2,1,1,2};
        System.out.println(robHouse(arr1));
        int [] arr2=new int[]{1};
        System.out.println(robHouse(arr2));
        int [] arr3=new int[]{1,2};
        System.out.println(robHouse(arr3));
    }

   static int robHouse(int[] arr){
        int dp[]=new int[arr.length+1];
        dp[0]=0;
        dp[1]=arr[0];
        int max=0;
        for(int length=1;length<arr.length;length++){
          max= Math.max(dp[length-1]+arr[length],dp[length]);
          dp[length+1]=max;
        }

        return dp[arr.length];

    }
}
