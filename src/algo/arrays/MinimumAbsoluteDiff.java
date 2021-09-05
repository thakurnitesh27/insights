package algo.arrays;

public class MinimumAbsoluteDiff {

    public static void main(String[] args) {
        int[] arr=new int[]{2,2,2};

        System.out.println(findMaxAbs(arr));
    }

  static int findMaxAbs(int []arr)
    {
        if(arr.length==1)
        {
            return Math.abs(arr[0]);
        }
        int min1=arr[0],max1=arr[0],min2=arr[0],max2=arr[0];
        for(int i=1;i<arr.length;i++)
        {

           int d1= arr[i]+i;
           if(d1>max1)
           {
               max1=d1;
           }
           else if(d1<min1)
           {
               min1=d1;
           }

           int d2=arr[i]-i;
           if(d2>max2)
           {
               max2=d2;
           }
           else if(d2<min2)
           {
               min2=d2;
           }


        }

        System.out.println("Max1: "+ max1+"Max2: "+ max2+" Min1:"+min1 +" Min2: "+min2);

        return Math.max(max1-min1,(max2-min2));
    }
}
