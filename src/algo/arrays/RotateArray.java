package algo.arrays;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=
// interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class RotateArray {
    public static void main(String[] args) {

        Integer[] arr=new Integer[]{1,2,3,4,5};
        Integer[] ans=rotateLeft(arr,4);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

    public static Integer[] rotateLeft(Integer[] arr, int noOfRotation){

        if(arr!=null && noOfRotation<arr.length){

            Integer[] ans=new Integer[arr.length];
            int j=0;
            for(int i=noOfRotation;i<arr.length;i++){

                ans[j]=arr[i];
                j++;
            }
            for(int i=0;i<noOfRotation;i++){
                ans[j]=arr[i];
                j++;
            }
            return ans;
        }
        return arr;
    }
}
