package algo;

public class MaxUnSortedSubarray {

    int [] findMAxSubarray(int [] arr)
    {
        int max=-1;
        int min=-1;
        int sIndex=-1, eIndex=-1;

        for(int i=0;i<arr.length;i++)
        {
           if(i+1<=arr.length-1&&arr[i+1]<arr[i])
           {
               max=arr[i];
               //sIndex=i;
               if(sIndex==-1)
                   sIndex=i;
               eIndex=i;
           }
           else if(max!=-1&&max>arr[i]){
               eIndex=i;
           }

        }
        if(sIndex!=-1)
        return new int[]{sIndex,eIndex};
        else return new int[]{-1};
    }

    public static void main(String[] args) {
        MaxUnSortedSubarray maxUnSortedSubarray=new MaxUnSortedSubarray();
        int [] arr=new int[]{1,4,2,3,7,6,9};
        int [] arr1=new int[]{1,5,2,10,6,7,9};
        int [] arr2=new int[]{1,4,2,3,7,6,9};
        int [] arr3=new int[]{1,4,2,3,7,6,9};
        int [] arr4=new int[]{1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19 };
       int []ans= maxUnSortedSubarray.findMAxSubarray(arr1);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
