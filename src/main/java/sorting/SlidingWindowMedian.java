package sorting;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-median/description/
public class SlidingWindowMedian {
    public static void main(String[] args) {

            System.out.println(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,2},1));
       // System.out.println(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,4,3,0,2,7,6,5},2));
       // print(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
       // print(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2},3));
       // print(new SlidingWindowMedian().medianSlidingWindow(new int[]{2147483647,2147483647},2));
        print(new SlidingWindowMedian().medianSlidingWindow(new int[]{2147483647,1,2,3,4,5,6,7,2147483647},2));
    }

    static void print(double [] num){
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }

    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        boolean even=true;

        double[] ans=new double[nums.length-k+1];
        int index=0;
        for(int i=0;i<k;i++){

            if(even){
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
            }else {
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }
            even=!even;

        }


            if(even){
                ans[index++]=  (double) ((double)minHeap.peek()+(double)maxHeap.peek())/2;
            }
            else {
                ans[index++]=maxHeap.peek();
            }

            for(int i=k;i< nums.length;i++){

                int numToRemove=nums[i-k];
                int numToAdd=nums[i];
//
//                if(numToRemove<=maxHeap.peek()){
//                    maxHeap.remove(numToRemove);
//                    maxHeap.add(numToAdd);
//                    minHeap.add(maxHeap.poll());
//                    maxHeap.add(minHeap.poll());
//                }
//                else {
//                    minHeap.remove(numToRemove);
//                    maxHeap.add(numToAdd);
//                    minHeap.add(maxHeap.poll());
//                }

             //   if(maxHeap.size()==minHeap.size()){
                if(! maxHeap.remove(numToRemove)){
                    minHeap.remove(numToRemove);
                    minHeap.add(numToAdd);
                }else
                    maxHeap.add(numToAdd);
              //  }
                rebalance(maxHeap,minHeap);
               // even=!even;


                    if(maxHeap.size()==minHeap.size()){
                    ans[i-k+1]=(double) ((double)minHeap.peek()+(double)maxHeap.peek())/2;;
                }
                else {
                    ans[i-k+1]=(double)maxHeap.peek();
                }


            }

            return ans;



    }

    private void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(minHeap.size()>0 &&maxHeap.peek()<minHeap.peek()){
            while (maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            while (maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }

        }else {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
}
