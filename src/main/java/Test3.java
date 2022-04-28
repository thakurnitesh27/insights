import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) {
        int[]arr=new int[]{10,-1,-4,3,-10,4};
        //10,3,3,4

        System.out.println(findMaximumInSubarrays(arr,3));
    }

  static ArrayList<Integer> findMaximumInSubarrays(int[] arr, int k){
       ArrayList<Integer> response=new ArrayList<>();
       int wl=0,wr=0;
       int max=Integer.MIN_VALUE;
       while (wr<arr.length){
           if(wr-wl<k){
               if(arr[wr]>max){
                   max=arr[wr];
               }
               wr++;

           }
           else {
               response.add(max);
               if(arr[wl]==max){
                   wl++;
                   wr=wl;
                   max=Integer.MIN_VALUE;
               }
               else {
                   wl++;
               }

           }
       }
       return response;
    }
}
