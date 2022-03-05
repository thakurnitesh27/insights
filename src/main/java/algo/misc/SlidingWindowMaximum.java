package algo.misc;

import java.util.ArrayList;
/*
Used sliding window to find the maximum for each window.
At first, calculate the max for 0 to B-1.And for each iteration  there after, check if wl-1 was the maximum for last iteration.
If yes, then we need to find the new maximum from wl to wr because any elements can be maximum.

If no, then maximum element still exists between wl and wr-1. We just need to find the maximum between last-max and arr[wr].
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

      //  int [] arr=new int[]{1, 3, -1 ,-3, 5, 3 ,6 ,7};

       // print(new SlidingWindowMaximum().slidingMaximum(arr,3));

     // int[]  arr=new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      int[]  arr=new int[]{713, 643, 171, 970, 755, 525, 932, 19, 210, 590, 249, 795, 323, 570};
       print(new SlidingWindowMaximum().slidingMaximum(arr,3));
    }

    public int[] slidingMaximum(final int[] arr, int B) {

        if(B>=arr.length){
            return new int[]{max(arr,0,arr.length-1)};
        }

        int wl=0,wr=B-1;
        ArrayList<Integer> list=new ArrayList<>();

        int max=max(arr,0,B-1);
       // list.add(max);

        while (wr<arr.length){
              //  list.add(max(arr,wl,wr));
            if(wl>0&&max==arr[wl-1]){
                max=max(arr,wl,wr);
            }
            else {
                max=Math.max(max,arr[wr]);
            }

            list.add(max);

           // }
            wr++;
            wl++;



        }
        int ans[]=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    private int max(int[] arr,int wl, int wr) {
        int max=Integer.MIN_VALUE;

        for(int i=wl;i<=wr;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }

        return max;
    }

    static void print(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

    }
}
