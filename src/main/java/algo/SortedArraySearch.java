package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedArraySearch
{

   static int pivot=-2;
    public static void main(String[] args)
    {
        List<Integer> list=new ArrayList<>();
        Integer [] demo=new Integer[1];
        Integer [] arr1=list.toArray(demo);
        //Integer arr[]=new Integer[]{3,4,5,6,7,0,1,2};
        //Integer arr[]=new Integer[]{1, 7, 67, 133, 178 };
        Integer arr[]=new Integer[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        int num=202;
       findPivot(arr,0,arr.length-1);
       if(pivot==-2)
           pivot=arr.length-1;
int answer=0;
if(pivot==arr.length-1||arr[arr.length-1]<num)
    answer= performBinarySearch(arr,0,pivot,num);
else

       {
answer=performBinarySearch(arr,pivot+1,arr.length-1,num);
       }
//       else
//       {
//           answer=performBinarySearch(arr,0,pivot,num);
//       }

        System.out.println(answer);




    }

   static void findPivot(Integer [] arr,int start, int end) {

       //}
       // {

//       for(int i=1;i<arr.length;i++)
//       {
//           if(arr[i-1]>arr[i])
//               return i-1;
//       }
       if (pivot != -2)
           return;
       //return arr.length-1;
       if (start < end) {
           int mid = start + (end - start) / 2;

           if (mid > 1 && mid < arr.length - 1) {
               if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
                   pivot = mid;

           }
           findPivot(arr, start, mid);
           findPivot(arr, mid + 1, end);

       }
   }


static   int  performBinarySearch(Integer []arr,int start, int end,int num)
  {

      if(start<end)
      {
          int mid=start+((end-start)/2);
          if(arr[mid]==num)
              return mid;
          if(num<arr[mid])
          {
              return performBinarySearch(arr,start,mid,num);
          }
          else
          {
              return performBinarySearch(arr,mid+1,end,num);
          }
      }
      else if(start==end)
      {
          if(num==arr[start])
              return start;
          else
              return -1;
      }
      return -1;

  }
}
