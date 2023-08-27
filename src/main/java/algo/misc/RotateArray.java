package algo.misc;

public class RotateArray {
    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,4,5,6,7};
        rotate(arr,2);
        print(arr);
        arr=new int[]{1,2,3,4,5,6};
        rotate(arr,3);
        print(arr);
        arr=new int[]{-1,-100,3,99};
        rotate(arr,3);
        print(arr);

    }

    public static void print(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void rotate(int[] nums,int k){
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public static void reverse(int[] nums, int startIndex, int endIndex){
        while (startIndex<endIndex){
            int temp=nums[startIndex];
            nums[startIndex]=nums[endIndex];
            nums[endIndex]=temp;
            startIndex++;
            endIndex--;
        }
    }
    public static void rotateOld(int[] nums, int k) {


        int t=k%2==0 && nums.length>2?nums.length-k:1;
        for(int i=0;i<t;i++) {
            int startIndex = i;

            int index = startIndex + k;
            if(index>nums.length-1){
                index=index%nums.length;
            }
            int temp = 0;
            int lastTemp = nums[startIndex];
            int lastIndex = -1;

            while (lastIndex != startIndex)     {
                temp = nums[index];
                nums[index] = lastTemp;
                lastIndex = index;
                lastTemp = temp;
                index = index + k;
                if (index > nums.length - 1) {
                    index = index % nums.length;
                }
            }

           // print(nums);
        }

    }
}
