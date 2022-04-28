package algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-cost-to-merge-stones/
public class MinimumCostToMergeStones {


    public static void main(String[] args) {

        int[] arr=new int[]{6,4,4,6};
        System.out.println(new MinimumCostToMergeStones().findMinimumCost(arr,2));
        arr=new int[]{3,2,4,1};
        System.out.println(new MinimumCostToMergeStones().findMinimumCost(arr,2));
        System.out.println(new MinimumCostToMergeStones().findMinimumCost(arr,3));

        arr=new int[]{3,5,1,2,6};
        System.out.println(new MinimumCostToMergeStones().findMinimumCost(arr,3));
    }

   int findMinimumCost(int[] arr, int k){

       List<Integer> arrayList= new ArrayList();

       for(Integer i:arr){
           arrayList.add(i);
       }

       int minimumSum=0;

       while (arrayList.size()>=k) {
         minimumSum+=  findAndReplaceMinimumCostIndex(arrayList, k);
       }

       if(arrayList.size()>1){
           return -1;
       }

       return minimumSum;


   }

   int findAndReplaceMinimumCostIndex(List<Integer> list,int k){

        int wl=0,wr=0;

        int count=0,minimumSum=Integer.MAX_VALUE,index1=0,index2=0;

        while (wr<list.size()){
            if((wr-wl)<k){
                count+=list.get(wr);
                wr++;

            }
            else {
                if(count<minimumSum){
                    minimumSum=count;
                    index1=wl;
                    index2=wr-1;
                }
                count-=list.get(wl);
                wl++;
            }
        };

       if(count<minimumSum){
           minimumSum=count;
           index1=wl;
           index2=wr-1;
       }

        for(int i=index1;i<=index2;i++){
            list.remove(index1);
        }
        list.add(index1,minimumSum);

        return minimumSum;

   }


}
