package algo.misc;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {

        int[]arr=new int[]{1,4,8,13};
        System.out.println(maxFrequency(arr,8));

        arr=new int[] {9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,
                9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,
                9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,
                9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,
                9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
       // 3056

        System.out.println(maxFrequency(arr,3056));



    }
    /*
    1,4,8,13, k=8
    when we increment 1 by 3, 1 becomes 4, so 4,4 is max frequency. and we decrement k by 3.
    When we move wr to 8, 4 and 1 will be incremented to make them 8. Increment 4 by 4 and since 1 was already
    made 4 in last operation, we also need to increment it by 4. So always, wr-1 i index element wil be the number to which every
    element between wl and wr-1 will be same. So (num[wr]-num[wr-1])*(wr-wl) will give the number of operations
    to make all elements between wl and wr-1 to make them equal to num[wr].

     */

    public static int maxFrequency(int[] nums, int k) {
        int count=0;
        int maxCount=0;
        int wl=0,wr=1;
        Arrays.sort(nums);
        int operation=k;
        while(wr<nums.length){

            if((nums[wr]-nums[wr-1])*(wr-wl)<=operation){
                operation-=(nums[wr]-nums[wr-1])*(wr-wl);

                count=Math.max(count,wr-wl+1);


                wr++;

            }
            else{
                operation+=(nums[wr-1]-nums[wl]);
                // operation=Math.min(operation,k);
                wl++;
            }

        }

        return count;

    }


}
