package algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
public class MinimumOperationsToMakeArrayContinuous {
    public static void main(String[] args) {

        //int []arr=new int[]{10,11,13,14,15,16,21,22,20};
        int []arr=new int[]{41,33,29,33,35,26,47,24,18,28}; //18,24,26,28,29,33,33,35,41,47

        /*
        i=1, 18,24,26,28,29,33,33,35,41,19
        i=1,18,24,26,28,29,33,33,35,20,19
        i=1,18,24,26,28,29,33,33,21,20,19
        i=1,18,24,26,28,29,33,22,21,20,19
        i=1,18,24,26,28,29,23,22,21,20,19
        i=2,18,24,26,28,29,23,22,21,20,19
        i=2,18,24,26,28,25,23,22,21,20,19
        i=3,18,24,26,27,25,23,22,21,20,19
        i=3,18,24,26,27,25,23,22,21,20,19 //7

        [18,24,26][28,29][33,33,35,41,47]
        [25,26,27][28,29][30,31,32,33,34]

        24,25,26,27,28,29,30,31,32,33


        18,24,26,28,29,33,33,35,41,19
        25,26,27,28,29,30,31,32,33,34

         */

        //int []arr=new int[]{1,2,3,5,6};
        //int []arr=new int[]{1,10,100,1000};
        System.out.println(new MinimumOperationsToMakeArrayContinuous().minOperations(arr));

    }


    public int minOperations(int[] nums) {

        Arrays.sort(nums);

        int num=nums[0];
        int maxContinuous=Integer.MIN_VALUE;
        int maxContinuousIndex=0;
        int count=0;
        int i=0;
      //  for(int i=0;i<nums.length;i++){
        while (i<nums.length){
            if(nums[i]==num){
                num++;
                count++;
                i++;
            }
            else {
                num=nums[i];
                count=0;
               // i++;
            }

            if(count>maxContinuous){
                maxContinuous=count;
                maxContinuousIndex=i-1;

            }

        }

        int firstIndex=maxContinuousIndex-maxContinuous+1;
       // ArrayList expe
        int changesToMake=Integer.MAX_VALUE;
        if(firstIndex>0) {

            int smallestNoInSeries =nums[firstIndex];
            int elementsToConsiderIndex=0;

            for(i=0;i<firstIndex;i++){

                if(smallestNoInSeries-nums[i]>=nums.length){
                    elementsToConsiderIndex++;

                }
                else {
                    break;
                }
            }


            for(i=elementsToConsiderIndex;i<firstIndex;i++){
                int j=i;
                int currentChanges=0;
                int tmp=1;
               // int currentNum=nums[j];
                while (j<firstIndex) {

                    if (nums[j+1] == nums[j]+tmp) {
                        j++;
                        currentChanges+=(tmp-1);
                        tmp=1;
                        // continue;
                    } else {
                        tmp++;
                    }
                }

                changesToMake=Math.min(changesToMake,currentChanges);


            }

        }

        int lastIndex=maxContinuousIndex;

        if(lastIndex< nums.length){

            int elementsToConsiderIndex=lastIndex+1;
            for(i=elementsToConsiderIndex;i<nums.length;i++){
                if(nums[i]-nums[lastIndex]>=nums.length){
                    elementsToConsiderIndex++;
                }
                else {
                    break;
                }
            }

           // for(i=elementsToConsiderIndex;i<nums.length;i++)
            int largestNoInSeries =nums[lastIndex];
            int largestNoInArray=nums[nums.length-1];
            int sizeLimit=nums.length-lastIndex-1;

            ArrayList expectedSet=new ArrayList();
            ArrayList actualSet=new ArrayList();
            for(i=largestNoInSeries+1; i<=largestNoInArray&&expectedSet.size()<sizeLimit; i++){
                expectedSet.add(i);
            }

            for(i=lastIndex+1;i<nums.length;i++){
                actualSet.add(nums[i]);
            }
            expectedSet.removeAll(actualSet);
            changesToMake+=expectedSet.size();
        }
      //  changesToMake=Math.min(changesToMake,nums.length);

       return changesToMake;

    }





}
