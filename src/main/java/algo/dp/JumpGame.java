package algo.dp;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};

//        System.out.println(new JumpGame().canJump(arr));
//        System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
//        System.out.println(new JumpGame().canJump(new int[]{2,0,3,0,0,0}));

        System.out.println(new JumpGame().canJumpBottomUp(arr));
        System.out.println(new JumpGame().canJumpBottomUp(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpBottomUp(new int[]{2,0,3,0,0,0}));
    }

    boolean canJump(int[] nums) {
        int[] canJumpValue = new int[nums.length];
        Arrays.fill(canJumpValue, -1);
        return canJumpTopDown(nums, canJumpValue, 0);
    }


    boolean canJumpTopDown(int[] nums, int canJump[], int index) {

        // int[] canJump=new int[nums.length];

        if (index >= nums.length-1 ||(index<nums.length && (index+nums[index]>=nums.length-1))) {
            return true;
        }


        // for(int i=0;i<nums.length;i++){
        if (canJump[index] != -1) {
            return canJump[index] == 1;
        }
        boolean findValue = false;



        for (int i = index + 1; i <= index+nums[index]; i++) {

            findValue = findValue || canJumpTopDown(nums, canJump, i);
        }
        canJump[index] = findValue ? 1 : 0;
        return findValue;
    }


    boolean canJumpBottomUp(int[] nums){
        boolean[] isReachableFromEachIndex=new boolean[nums.length];
        isReachableFromEachIndex[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){

            if( i+nums[i]>=nums.length-1){
                isReachableFromEachIndex[i]=true;
                continue;
            }

            for(int j=i+1;j<=Math.min(nums.length-1,i+nums[i]);j++){
                if(isReachableFromEachIndex[j]==true){
                    isReachableFromEachIndex[i]=true;
                    break;
                }
            }

        }

        return isReachableFromEachIndex[0];
    }
}
