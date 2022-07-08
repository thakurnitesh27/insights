package algo.misc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubarrayWithAbsoluteDiff {
    public static void main(String[] args) {
         System.out.println(longestSubArrayUsingDeque(new int[]{8,2,4,7},4));
         System.out.println(longestSubArrayUsingDeque(new int[]{10,1,2,4,7,2},5));
        System.out.println(longestSubArrayUsingDeque(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));

    }

    public static int longestSubArrayUsingDeque(int[] nums,int limit){
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;

        int l = 0;

// find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {

            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static int longestSubarray(int[] nums, int limit) {

        int wl = 0, wr = 1;

        TreeMap<Integer,Integer> treeSet = new TreeMap<>();
        treeSet.put(nums[0],1);

        int ans = Integer.MIN_VALUE;
        int count = 1;
        while (wl < nums.length) {
            if (wr <= nums.length && treeSet.navigableKeySet().last() - treeSet.navigableKeySet().first() <= limit) {
                if(wr<nums.length) {
                    treeSet.put(nums[wr], treeSet.getOrDefault(nums[wr], 0) + 1);
                }
                ans = Math.max(ans, count);
                count++;
                wr++;
            } else {
                // ans=Math.max(ans,count);
                if(treeSet.get(nums[wl])==1){
                    treeSet.remove(nums[wl]);
                }else {
                    treeSet.put(nums[wl],treeSet.get(nums[wl])-1);
                }

                wl++;
                count = treeSet.size();
            }
        }

        return ans;
    }
}
