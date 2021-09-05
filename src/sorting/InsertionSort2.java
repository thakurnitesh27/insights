package sorting;

import java.util.Arrays;

public class InsertionSort2 {


    public static void main(String[] args) {
        int arr[]=new int[]{4,2,5,3,1,6,9,7,0,8};

        for(int i=1;i<arr.length;i++)
        {
            int currEle=arr[i];
            int lastIndex=i;  //this is pointed at i because currentEle can be greater than all other already sorted elements.
            // 9 for example here. In that case, it should just be same element at line 26.
            //
            for(int j=i-1;j>=0;j--)
            {
                if(currEle<arr[j])
                {
                    arr[j+1]=arr[j];
                    lastIndex=j;
                }
                else break;
            }
            arr[lastIndex]=currEle;
        }


        Arrays.stream(arr).forEach(System.out::print);
    }
}
