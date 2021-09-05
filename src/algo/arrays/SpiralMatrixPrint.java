package algo.arrays;

public class SpiralMatrixPrint {

    public static void main(String[] args) {
        int arr[][]=new int[][]{

                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
       int data[]= spiralPrint(arr);
       for(int i=0;i<data.length;i++)
       {
           System.out.println(data[i]);
       }
    }

  static   int[] spiralPrint(int[][] arr) {

        int [] resultArr=new int[arr.length*arr[0].length];
        int top = 0, left = 0;
        int bottom = arr.length - 1, right = arr[0].length - 1;

        int state = 0;
        int iteration = 0;
        while (top <= bottom && left <= right) {
            switch (state) {
                case 0: //left++,top=constant
                {
                    int i = left;

                    while (i <= right) {
                      //  System.out.print(arr[top][i++]);
                        resultArr[iteration]=arr[top][i++];
                        iteration++;

                    }
                    top++;
                    state = 1;

                    break;
                }

                case 1: { //top++,right=constant

                    int i = top;
                    while (i <= bottom) {
                      //  System.out.print(arr[i++][right]);
                        resultArr[iteration]=arr[i++][right];
                        iteration++;
                    }
                    right--;
                    state = 2;
                    break;
                }
                case 2: { //right--,bottom=constant

                    int i = right;
                    while (i >= left) {
                     //   System.out.println(arr[bottom][i--]);
                        resultArr[iteration]=arr[bottom][i--];
                        iteration++;
                    }
                    bottom--;
                    state = 3;
                    break;

                }

                case 3: { //bottom--,left=constant

                    int i = bottom;
                    while (i >= top) {
                     //   System.out.print(arr[i--][left]);
                        resultArr[iteration]=arr[i--][left];
                        iteration++;
                    }
                    left++;
                    state = 0;
                    break;

                }
            }

        }
        return resultArr;
    }
}



