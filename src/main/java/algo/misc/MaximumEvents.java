package algo.misc;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
public class MaximumEvents {
    public static void main(String[] args) {

        System.out.println(maxEvents(new int[][]{ {1, 2}, {2, 3}, {3, 4},{1,2}}));
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int currentDay = 1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        int ans=0;
        int maxDay = 10000;
        int index=0;

        while (currentDay < maxDay || !priorityQueue.isEmpty()) {


            while (!priorityQueue.isEmpty()&&priorityQueue.peek() < currentDay) {
                priorityQueue.poll();
            }

            while (index<events.length &&events[index][0]==currentDay){
                priorityQueue.add(events[index][1]);
                index++;
            }

            if(!priorityQueue.isEmpty()){
                priorityQueue.poll();
                ans++;
            }

            currentDay++;
            while (!priorityQueue.isEmpty() && currentDay > priorityQueue.peek()) {
                priorityQueue.poll();
            }



        }

        return ans;
    }
}
