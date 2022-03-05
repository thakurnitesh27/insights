package algo.arrays;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
public class MinimumMovesToMakeArrayEqual {

    public static void main(String[] args) {

//        int[] arr=new int[]{1,10,2,9};
//        int val=new MinimumMovesToMakeArrayEqual().minimumMoves(arr);
//      // assert 16==val:"Expected 16, found "+val;
//        System.out.println(val);

//        int [] arr=new int[]{1,0,0,8,6};
//        int val=new MinimumMovesToMakeArrayEqual().minimumMoves(arr);
//       // assert 14==val:"Expected 12, found "+val;
//        System.out.println(val);

//         arr=new int[]{1,2,5,8,0};
//         val=new MinimumMovesToMakeArrayEqual().minimumMoves(arr);
//        System.out.println(val);
//       // assert 13==val:"Expected 12, found "+val;

       int[] arr=new int[]{3,0,6,2,4,7,0,0};
       int val=new MinimumMovesToMakeArrayEqual().minimumMoves(arr);
        System.out.println(val);

    }

   int  minimumMoves(int [] arr){

        int sum=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
            sum+=arr[i];
        }

        int avg=sum/arr.length;

        int minChanges=0;

        for(int i=0;i<arr.length;i++){

            minChanges+=Math.abs(avg-arr[i]);
        }

        return findMinimum(arr,min,max,minChanges);

    }

    int findMinimum(int[] arr, int min,int max, int ans){

        if(min<=max ){
            int mid=(min+max)/2;
            if(min==max){

                if(max==0||max==1){
                    return ans;
                }
                mid=min/2;
            }


           int newAns= calculateMinimumMoves(arr,mid);

            if(newAns<ans){
                ans=newAns;

                return findMinimum(arr,mid,max,ans);
                //return   findMinimum(arr,min,mid-1,ans);

            }
            else {

                return   findMinimum(arr,min,mid,ans);
                //return findMinimum(arr,mid+1,max,ans);
            }


        }
        return ans;

    }


    int  calculateMinimumMoves(int[]arr, int num){

        int moves=0;

        for(int i=0;i<arr.length;i++){
            moves+=Math.abs(num-arr[i]);
        }
        return moves;
    }
}
