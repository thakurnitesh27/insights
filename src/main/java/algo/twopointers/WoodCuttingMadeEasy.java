public class WoodCuttingMadeEasy {
    public static void main(String[] args) {

       /* int arr[] = new int[]{20, 15, 10, 17};
        System.out.println(new WoodCuttingMadeEasy().cut(arr,7)); */
        int arr[] = new int[]{4, 42, 40, 26, 46};
        System.out.println(new WoodCuttingMadeEasy().cut(arr,20));

    }

    int cut(int arr[], int woodRequired) {

        int a[] = findMinMax(arr);

        return process(arr, woodRequired, a[0], a[1],0);


    }

    private int process(int[] arr, int woodRequired, int min, int max,int ans) {
        if (min <= max) {

            int mid = (min + max) / 2;
            boolean isCutValid=isCuttingAllowed(arr,woodRequired,mid);

            if(isCutValid){
                ans=mid;
               return process(arr,woodRequired,min,mid-1,ans);
            }
            else {
                return process(arr,woodRequired,mid+1,max,ans);
            }


        }
        return ans;
    }

    boolean isCuttingAllowed(int arr[], int woodRequired, int cut) {

        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>cut){
                sum+=(arr[i]-cut);
            }

        }
        if(sum==woodRequired){
            return true;
        }
        else return false;

    }

    private int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new int[]{min, max};
    }

}
