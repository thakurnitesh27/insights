package algo.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/
public class MinimumOperationsToMakeArrayAlternating {

    public static void main(String[] args) {
        int arr[]=new int[]{69,91,47,74,75,94,22,100,43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,79,43,56,74,30,71,6,100,72,93,83,40,28,79,24};
        System.out.println(new MinimumOperationsToMakeArrayAlternating().minimumOperationsNew(arr));
         arr=new int[]{4,2,6,3,4,2,1};
        System.out.println(new MinimumOperationsToMakeArrayAlternating().minimumOperationsNew(arr));
   arr=new int[]{3,1,3,2,4,3};
        System.out.println(new MinimumOperationsToMakeArrayAlternating().minimumOperationsNew(arr));
   arr=new int[]{1,2,2,2,2};
        System.out.println(new MinimumOperationsToMakeArrayAlternating().minimumOperationsNew(arr));
    }
    public int minimumOperationsCopied(int[] nums) {
        Map<Integer,Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) even.put(nums[i],even.getOrDefault(nums[i],0) + 1);
            else odd.put(nums[i],odd.getOrDefault(nums[i],0) + 1);
        }
        int oddKey1 = 0, oddKey2 = 0;
        int evenKey1 = 0, evenKey2 = 0;
        odd.put(0,0);
        even.put(0,0);
        for (int key : odd.keySet()) {
            if (odd.get(key) > odd.get(oddKey1)) {
                oddKey2 = oddKey1;
                oddKey1 = key;
            } else if (odd.get(key) > odd.get(oddKey2)){
                oddKey2 = key;
            }
        }

        for (int key : even.keySet()) {
            if (even.get(key) > even.get(evenKey1)) {
                evenKey2 = evenKey1;
                evenKey1 = key;
            } else if (even.get(key) > even.get(evenKey2)){
                evenKey2 = key;
            }
        }
        if (oddKey1 == evenKey1)
            return nums.length-Math.max(odd.get(oddKey1)+even.get(evenKey2)
                    , odd.get(oddKey2)+even.get(evenKey1));

        return nums.length-odd.get(oddKey1)-even.get(evenKey1);
    }

    public int minimumOperationsNew(int[] nums) {
        HashMap<Integer,Integer> set=new HashMap<>();
        HashMap<Integer,Integer> set1=new HashMap<>();

        int evenCount1=0, evenCount2=0,oddCount1=0,oddCount2=0;
        int evenNum1=0, evenNum2=0,oddNum1=0,oddNum2=0;
        for(int i=0;i<nums.length;i++){
          if(i%2==0){
              set.put(nums[i],set.getOrDefault(nums[i],0)+1);
          }
          else {
              set1.put(nums[i],set1.getOrDefault(nums[i],0)+1);
          }
        }

        for(int key:set.keySet()){
            if(set.get(key)>evenCount1){
                evenNum2=evenNum1;
                evenCount2=evenCount1;
                evenNum1=key;
                evenCount1=set.get(key);
            }else if(set.get(key)>evenCount2){
                evenCount2=set.get(key);
                evenNum2=key;
            }
        }

        for(int key:set1.keySet()){
            if(set1.get(key)>oddCount1){
                oddNum2=oddNum1;
                oddCount2=oddCount1;
                oddNum1=key;
                oddCount1=set1.get(key);
            }
            else if(set1.get(key)>oddCount2){
                oddCount2=set1.get(key);
                oddNum2=key;
            }
        }

      if(evenNum1==oddNum1){
        return   nums.length- Math.max(evenCount1+oddCount2,oddCount1+evenCount2);
      }

        return nums.length-oddCount1-evenCount1;


    }
    public int minimumOperations(int[] nums) {
        int maxCount=Integer.MIN_VALUE;

        HashMap<Integer,Integer> set=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int currentNum=nums[i];
//            if(set.keySet().contains(currentNum)){
//                continue;
//            }
            int count=1;
            int j=i+2;
            while (j< nums.length){
                if(nums[j]==currentNum){
                    count++;
                }

                j+=2;
            }
//            j=i-2;
//            while (j>=0){
//                if(nums[j]==currentNum){
//                    count++;
//                }
//
//                j-=2;
//            }

            if(count>maxCount){
               // set.clear();
                set.put(i,count);
                maxCount=count;
                //maxFrequencyNum=currentNum;
                //maxFrequenceIndex=i;
            }
//            else if(count==maxCount){
//                set.put(i,count);
//            }
            set.put(i,count);
        }

        int ans=Integer.MAX_VALUE;
        for(int key:set.keySet()) {
           int maxFrequenceIndex=set.get(key);
           int maxFrequencyNum=nums[key];

            int startIndex = maxFrequenceIndex % 2 == 0 ? 1 : 0;
            int num1 = maxFrequencyNum - 1;
            int count1 = 0;
            int count2 = 0;
            int num2 = maxFrequencyNum + 1;

            for (int i = startIndex; i < nums.length; i+=2) {
                if (nums[i] == num1) {
                    count1++;
                } else if (nums[i] == num2) {
                    count2++;
                }
            }

            int i = maxFrequenceIndex % 2 == 0 ? 0 : 1;
            int j = startIndex;
            int nextNum = count1 > count2 ? num1 : num2;

            int changes = nums.length-(maxCount+Math.max(count1,count2));

//            while (i < nums.length || j < nums.length) {
//
//                if (i < nums.length && nums[i] != maxFrequencyNum) {
//                    changes++;
//                }
//                if (j < nums.length && nums[j] != nextNum) {
//                    changes++;
//                }
//                i+=2;
//                j+=2;
//            }

            ans=Math.min(ans,changes);
        }

       return ans;


    }
}
