package algo.arrays;

import java.util.HashSet;

public class MinPositiveMissingNumber {

    public static void main(String[] args) {

        int[] arr=new int[]{2,1,3,4,4,3,1,1};
        System.out.println(findMinPositive(arr));
    }

   static int findMinPositive(int []num)
    {
        if(num==null || num.length==0)
        {
            return 1;
        }
        if(num.length==1)
        {
            return num[0]!=1?1:2;
        }
        int min=num[0],max=num[0];
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<num.length;i++)
        {
            if(num[i]<=0)
            {
                continue;
            }
            if(min<0)
            {
                min=num[i];
            }
            if(num[i]<min)
            {
                min=num[i];
            }

            else if(num[i]>max)
            {
                max=num[i];
            }
            set.add(num[i]);
        }

        if(min>1|| min<0)
        {
            return 1;
        }

        for(int i=min+1;i<max;i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return max+1;
    }


}
