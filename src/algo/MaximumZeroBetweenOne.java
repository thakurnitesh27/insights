package algo;

public class MaximumZeroBetweenOne {

  int  findMaxZero(int [] arr)
    {
        int max=-1;
        int beginIndex=0;
        int endIndex=0;
        for(int i=0;i<arr.length;i++)
        {
         if(arr[i]==1)
         {
             if(endIndex-beginIndex>max)
             {
                 max=endIndex-beginIndex;
             }
             beginIndex=i;
             endIndex=i;
         }
         else
             endIndex=i;
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumZeroBetweenOne maximumZeroBetweenOne=new MaximumZeroBetweenOne();
        int arr[]={1,0,0,1,0,1};
        int arr1[]={1,0,1,0,1};

        System.out.println(maximumZeroBetweenOne.findMaxZero(arr));
        System.out.println(maximumZeroBetweenOne.findMaxZero(arr1));
    }
}
