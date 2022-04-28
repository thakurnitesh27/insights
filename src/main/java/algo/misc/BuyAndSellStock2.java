package algo.misc;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class BuyAndSellStock2 {

    public static void main(String[] args) {

        int []arr=new int[]{7,1,5,3,6,4};

        System.out.println(new BuyAndSellStock2().findMaxProfit(arr));
    }

    int findMaxProfit(int[] arr){

        int temp=arr[0];

        for(int i=1;i<arr.length;i++){


            int newTmp=arr[i];
            arr[i]=arr[i]-temp;
            temp=newTmp;

        }

        int sum=0;
        for(int i=1;i<arr.length;i++){

            if(arr[i]>0){
                sum+=arr[i];
            }
        }

        return sum;

    }

}
