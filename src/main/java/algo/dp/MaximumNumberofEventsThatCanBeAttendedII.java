package algo.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
public class MaximumNumberofEventsThatCanBeAttendedII {
    public static void main(String[] args) {
        int[][] arr=new int[][]{
                {1,2,4},{3,4,3},{2,3,10}};

        System.out.println(new MaximumNumberofEventsThatCanBeAttendedII().maxValue(arr,2));
    }

    public int maxValue(int[][] events, int k) {

        int n = events.length;
        Arrays.sort(events, (a, b) -> (a[1] - b[1]));
        TreeMap<Integer, Integer> dp1 = new TreeMap<>();
        TreeMap<Integer, Integer> dp2 = new TreeMap<>();
        dp1.put(0, 0);
        dp2.put(0, 0);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                int cur = dp1.lowerEntry(events[j][0]).getValue();
                if(cur + events[j][2] > dp2.lastEntry().getValue()) {
                    dp2.put(events[j][1], cur + events[j][2]);
                }
            }
            dp1 = dp2;
            dp2 = new TreeMap<>();
            dp2.put(0, 0);
        }
        return dp1.lastEntry().getValue();

    }

//    private int dp(int[][]events,int k) {
//
//        Arrays.sort(events, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//               int c=  ( (Integer)o1[0]).compareTo(o2[0]);
//
//               if(c==0){
//                   c=( (Integer)o1[1]).compareTo(o2[1]);
//               }
//
//               return c;
//            }
//        });
//        int c[][]=new int[events.length][events.length];
//
//        int minDay=events[0][0];
//        int endDay=events[events.length-1][1];
//
//
//        for(int size=1;size<=k;size++){
//
//            for(int i=minDay;i<endDay-size;i++){
//                int j=i+size;
//                for(int t=i;t<=j;t++){
//
//                }
//            }
//
//        }
//
//    }
}
