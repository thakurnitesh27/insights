package algo.binarysearch;

//https://www.interviewbit.com/problems/capacity-to-ship-packages-within-b-days/
public class ShipPackages {

    public static void main(String[] args) {
      //  int arr[]=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      //  int B=5;

       // int arr[]=new int[]{3, 2, 2, 4, 1, 4};
       // int B=3;
        int arr[]=new int[]{16, 2, 11, 4, 18, 17, 17, 8, 8, 6, 7, 9, 17, 20, 10, 5, 2, 11, 3};
        int B=10;

        System.out.println(new ShipPackages().process(arr,B));
    }

    int process(int[]arr, int days){
        int[] resp=findMinAndMax(arr);
        int min=resp[0],max=resp[1];
      return   findMinimumWeightOfShip(arr,days,min,max,Integer.MAX_VALUE);
    }

    int findMinimumWeightOfShip(int[] arr, int days,int min,int max,int ans){
        if(min<=max) {
            int mid = (min + max) / 2;

            boolean isFeasible = isFeasible(arr, days, mid);

            if (isFeasible) {
                if(mid<ans){
                    ans = mid;
                }

                return findMinimumWeightOfShip(arr, days, min, mid-1, ans);
            } else {
                return findMinimumWeightOfShip(arr, days, mid+1, max, ans);
            }
        }
        return ans;

    }

    private boolean isFeasible(int[] arr, int days, int mid) {

        int noOfDays=0;
        int weightSum=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i]>mid){
                return false;
            }

            weightSum+=arr[i];
            if(weightSum>mid){
                noOfDays++;
                weightSum=arr[i];
            }

        }

        if(weightSum>0){
            noOfDays++;
        }

        if(noOfDays>days){
            return false;
        }
        return true;
    }

    private int[] findMinAndMax(int[] arr) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            sum+=arr[i];
        }

        return new int[]{min,sum};
    }
}
