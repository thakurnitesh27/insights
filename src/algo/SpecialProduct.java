package algo;

public class SpecialProduct {

    public static void main(String[] args) {
        //int []arr= new int[]{ 3, 6, 8, 9 , 2, 4};
        int []arr= new int[]{ 7, 5, 7, 9, 8, 7};
        System.out.println(findSpecialProduct(arr));
    }

    public static int findSpecialProduct(int []arr)
    {

        int maxProduct=0;

        for(int i=1;i<arr.length-1;i++)
        {
           int leftIndex=i-1;
           int rightIndex=i+1;
            int leftVal=0;
            int rightVal=0;
           while (leftIndex>=0)
           {
               if(arr[leftIndex]>arr[i])
               {
                   leftVal=leftIndex;
                   break;
               }
               leftIndex--;
           }

           while (rightIndex<arr.length)
           {
               if(arr[rightIndex]>arr[i])
               {
                   rightVal=rightIndex;
                   break;
               }
               rightIndex++;
           }
           if(leftVal*rightVal>maxProduct)
               maxProduct=leftVal*rightVal;

        }

        return maxProduct;

    }
}
