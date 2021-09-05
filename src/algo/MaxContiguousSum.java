package algo;

public class MaxContiguousSum

{

    public static void main(String[] args) {
        int arr[]=new int[]{2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubArray(arr));

    }

    public static int findMaxSubArray(int []arr)
    {
        int maxSum=0;
        int tempSum=0;
        for(int i=0;i<arr.length;i++)
        {
           tempSum+=arr[i];
           if(tempSum<0)
           {
               tempSum=0;
           }
           if(tempSum>maxSum)
               maxSum=tempSum;
        }

        return maxSum;
    }
}
