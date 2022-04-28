package algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    public static void main(String[] args) {
        int [][]arr=new int[][]{{1,3},{8,10},{2,6},{15,18}};
        arr=new int[][]{{1,4},{0,2},{3,5}};

        System.out.println(mergeIntervals(arr));

    }

    static int[][] mergeIntervals(int[][]arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((Integer)o1[0]).compareTo((Integer)o2[0]);
            }
        });

        List<int[]> response=new ArrayList<>();
        response.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            int[] lastElemet=response.get(response.size()-1);
            if(arr[i][0]>=lastElemet[0] && arr[i][0]<=lastElemet[1]){
                int [] temp=new int[2];
                temp[0]=lastElemet[0];
                temp[1]=Math.max(arr[i][1],lastElemet[1]);
                response.set(response.size()-1,temp);
            }
            else {
                response.add(arr[i]);
            }
        }
        return response.toArray(new int[1][]);
    }
}
