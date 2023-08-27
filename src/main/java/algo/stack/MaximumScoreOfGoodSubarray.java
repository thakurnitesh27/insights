package algo.stack;

import java.util.Stack;

public class MaximumScoreOfGoodSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 7, 4, 5};

        System.out.println(maximumScore(arr,3));
        System.out.println(maximumScore(new int[]{5,5,4,5,4,1,1,1},3));
    }

    public static int maximumScore(int[] nums, int k) {
        int length = nums.length;

        Integer[] leftIndexes = new Integer[length];
        Integer[] rightIndexes = new Integer[length];
        for(int i=0;i<length;i++){
            rightIndexes[i]=length-1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int j = stack.pop();
                rightIndexes[j] = i-1;
            }
            leftIndexes[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            stack.push(i);
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<length;i++){
            if(leftIndexes[i]<=k && k<=rightIndexes[i]){
                int distance=rightIndexes[i]-leftIndexes[i];
                max=Math.max(max,nums[i]*(distance+1));
            }
        }

        return max;

    }
}
