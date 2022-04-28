package algo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubarrayMinimum {

    public static void main(String[] args) {

        //  System.out.println(new SumOfSubarrayMinimum().findMinimumSums(new int[]{3,1,2,4}));
      //  int[] arr = new int[]{30, 12, 25, 20, 18, 19, 4};
        int[] arr = new int[]{3,1,7,4};
        //  System.out.println(new SumOfSubarrayMinimum().findPreviousLessElement(arr));
        System.out.println(new SumOfSubarrayMinimum().findMinimumSums(arr));
    }

    List<Integer> findPreviousLessElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> previousLess = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            previousLess.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        return previousLess;
    }

    List<Integer> findNextLessElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        // List<Integer> nextLess=new ArrayList<>();
        int[] nextLess = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                // nextLess.add(j,i);
                nextLess[j] = i;

            }
            stack.push(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nextLess.length; i++) {
            ans.add(arr[nextLess[i]]);

        }

        return ans;

    }

    int findMinimumSums(int[]arr){

        Stack<Integer> stack=new Stack<>();
        int[] leftIndexes=new int[arr.length];
        int[] rightIndexes=new int[arr.length];

        for(int i = 0; i < arr.length; i++) leftIndexes[i] =  i +1;
        for(int i = 0; i < arr.length; i++) rightIndexes[i] = arr.length - i;


        for(int i=0;i<arr.length;i++){

            while (!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            leftIndexes[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int j=stack.pop();
                rightIndexes[j]=i-j;
            }
            stack.push(i);
        }

        int ans=0;
      //  int mod=1e9+7;

        for(int i=0;i<leftIndexes.length;i++){
            ans+=(arr[i]*leftIndexes[i]*rightIndexes[i]%(1e9+7));
        }

        return ans;
    }

    int findMinimumSumsOld(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int min = 0;
        for (int i = 0; i < arr.length; i++) {

            while (!stack.empty() && arr[i] < arr[stack.peek()]) {
                int j = stack.pop();
                min += arr[i] * (i - j);
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                int j = stack.pop();
                min += arr[i] * (i - j);
            }
            stack.push(i);
        }
        return min;
    }
}
