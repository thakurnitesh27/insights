package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MonotonicQueue {

    public static void main(String[] args) {
       // new MonotonicQueue().findFirstSmallestElementUsingIncreasingMonotonicQueue(new int[]{5,8, 3, 1, 2, 4});
        new MonotonicQueue().findNextSmallerElementUsingIncreasingQueue(new int[]{8,7,4,2,8,1,7,7,10,2});
    }

    int [] findFirstSmallestElementUsingIncreasingMonotonicQueue(int[] num){ //to the left

        Queue<Integer> queue=new LinkedList<>();

        int[] ans=new int[num.length];

        int index=0;


        while (index<num.length){


            int currentElement=num[index];

            while (!queue.isEmpty() && num[((LinkedList<Integer>) queue).peekLast()]>currentElement){
                ((LinkedList<Integer>) queue).pollLast();
            }
            ans[index]=!queue.isEmpty()? num[((LinkedList<Integer>) queue).peekFirst()]:-1;
            ((LinkedList<Integer>) queue).add(index);
            index++;
        }

        return ans;


    }

    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/ --Using increasing monotonic array

    int[] findNextSmallerElementUsingIncreasingQueue(int[] num){

        LinkedList<Integer> queue=new LinkedList<>();

        int index=0;
        int[] ans=new int[num.length];

        Arrays.fill(ans,-1);

        while (index<num.length){
            int currentElement=num[index];

            while (!queue.isEmpty() && num[((LinkedList<Integer>) queue).peekLast()]>=currentElement){

                ans[ ((LinkedList<Integer>) queue).pollLast()]=currentElement;
            }
            ((LinkedList<Integer>) queue).add(index);

            index++;
        }

        return ans;
    }


}
