package algo.backtracking;
//https://leetcode.com/problems/jump-game-iii/
public class JumpGame3 {

    public static void main(String[] args) {
        int[]arr=new int[]{4,2,3,0,3,1,2};
        System.out.println(isZeroFound(arr,5));
        int[]arr1=new int[]{4,2,3,0,3,1,2};
        System.out.println(isZeroFound(arr1,0));
        int[]arr2=new int[]{3,0,2,1,2};
        System.out.println(isZeroFound(arr1,2));
    }

   static boolean isZeroFound(int[]arr,int index){

        if(index<arr.length && index>-1){
            if(arr[index]==0){
                return true;
            }
            if(arr[index]==-1){
                return false;
            }
            int leftIndex=index-arr[index];
            int rightIndex=index+arr[index];
            arr[index]=-1;

           return isZeroFound(arr,leftIndex) || isZeroFound(arr,rightIndex);

        }
        return false;
    }
}
