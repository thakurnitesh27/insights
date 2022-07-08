package algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        //print(maxSlidingWindow(new int[]{1,-1},1));
        print(maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},
        5));
        print(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},
        3));
       print(maxSlidingWindow(new int[]{1},
        1));



    }

    static void print(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxDeque = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {

            while (!maxDeque.isEmpty() &&nums[maxDeque.peekLast()] < nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.add(i);
        }
        int wr=k-1;
        int []ans=new int[nums.length-k+1];
        int index=0;
        while (wr<nums.length){

            while (!maxDeque.isEmpty() && maxDeque.peekFirst()<wr-k+1){
                maxDeque.pollFirst();
            }
            while (!maxDeque.isEmpty() &&nums[maxDeque.peekLast()] < nums[wr]) {
                maxDeque.pollLast();
            }
            maxDeque.add(wr);
            ans[index]=nums[maxDeque.peekFirst()];
           // maxDeque.remove(nums[wl]);

            wr++;
            index++;

        }

        return ans;

    }

    public int[] maxSlidingWindowOld(int[] nums, int k) {
        int wl = 0, wr = k - 1;

        //  int max=Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < wr; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        while (wr < nums.length) {
            map.put(nums[wr], map.getOrDefault(nums[wr], 0) + 1);
            Integer max = map.lastKey();
            ans[index] = max;
            int wlElement = nums[wl];
            if (map.get(wlElement) > 1) {
                map.put(wlElement, map.get(wlElement) - 1);
            } else {
                map.remove(wlElement);
            }
            wl++;
            wr++;
            index++;

        }

        return ans;

    }
}
