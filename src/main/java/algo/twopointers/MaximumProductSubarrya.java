package algo.twopointers;
//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarrya {
    public static void main(String[] args) {
//        int[]arr3=new int[]{0,2};
//        System.out.println(maxProduct2(arr3));
        int[]arr=new int[]{2,3,-2,4};
        System.out.println(maxProduct2(arr));
        int[]arr1=new int[]{-2,-3,-4,-5};
        System.out.println(maxProduct2(arr1));
        int[]arr2=new int[]{-1,0,-1};
        System.out.println(maxProduct2(arr2));
    }

    static int maxProduct(int[]arr){
        int[][]m=new int[arr.length][arr.length];
        if (arr.length < 2) {

            return arr[0];
        }
        int n=arr.length;
        int maxProduct=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            m[i][i]=arr[i];
            maxProduct=Math.max(maxProduct,arr[i]);
        }


        for(int length=2;length<=arr.length;length++){

            for(int startIndex=0;startIndex<=n-length;startIndex++){

                int endIndex=startIndex+length-1;

                int product=m[startIndex][endIndex-1]*arr[endIndex];
                maxProduct=Math.max(maxProduct,product);
                m[startIndex][endIndex]=product;
            }

        }
        return maxProduct;
    }

   static int maxProduct2(int[]arr){
        int maxProduct=Integer.MIN_VALUE;

        int wr=1;
        int product=1;
        int currMax=arr[0];
        int currMin=arr[0];
        while (wr<arr.length){


           int tempMax= Math.max(arr[wr],Math.max(arr[wr]*currMax,arr[wr]*currMin));
            currMin=Math.min(arr[wr],Math.min(arr[wr]*currMax,arr[wr]*currMin));
            currMax=tempMax;
            maxProduct=Math.max(maxProduct,currMax);
            wr++;


        }


        return maxProduct;


    }
}
