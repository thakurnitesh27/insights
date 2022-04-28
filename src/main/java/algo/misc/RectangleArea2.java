package algo.misc;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/rectangle-area-ii/
public class RectangleArea2 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 0, 2, 3}, {1, 0, 3, 1}, {0, 0, 2, 2}
        };

      //  System.out.println(new RectangleArea2().findArea(arr));

        arr = new int[][]{
                {0,0,3,3},{2,0,5,3},{1,1,4,4} //18
        };

        System.out.println(new RectangleArea2().findArea(arr));


         arr = new int[][]{
                {0,0,1000000000,1000000000}
        };

        System.out.println(new RectangleArea2().findArea(arr));
        arr = new int[][]{
                {0,0,1,1},{2,2,3,3}
        };

        System.out.println(new RectangleArea2().findArea(arr));

        System.out.println(new RectangleArea2().findArea(arr));
        arr = new int[][]{
                {0,0,3,3},{1,1,2,2}
        };

        System.out.println(new RectangleArea2().findArea(arr));
    }

    int findArea(int[][] arr){

        Arrays.sort(arr, getComparator());

        int[] lastIndexValue=arr[0];
        double area=(((lastIndexValue[2]-lastIndexValue[0])%((Math.pow(10,9))+7))*
                ((lastIndexValue[3]-lastIndexValue[1])%((Math.pow(10,9))+7)))%((Math.pow(10,9))+7);
       // double area=0;

        for(int i=1;i<arr.length;i++){
            int [] currentIndexValue=arr[i];
            double commonArea=0;

            for(int j=i-1;j>=0;j--) {

                lastIndexValue = arr[j];
                if (currentIndexValue[0] <= lastIndexValue[2] && currentIndexValue[1] <= lastIndexValue[3]) {
                    int maxIP1 = Math.max(currentIndexValue[0], lastIndexValue[0]);
                    int maxJP1 = Math.max(currentIndexValue[1], lastIndexValue[1]);
                    int maxIP2 = Math.min(currentIndexValue[2], lastIndexValue[2]);
                    int maxJP2 = Math.min(currentIndexValue[3], lastIndexValue[3]);
                    commonArea += ((maxIP2 - maxIP1) % ((Math.pow(10, 9)) + 7)) * ((maxJP2 - maxJP1) % ((Math.pow(10, 9)) + 7));
                }
                else {
                    break;
                }
            }

           double currentArea=(((currentIndexValue[2]-currentIndexValue[0])%((Math.pow(10,9))+7))*
                   ((currentIndexValue[3]-currentIndexValue[1])%((Math.pow(10,9))+7)))%((Math.pow(10,9))+7);
          // int lastArea=(lastIndexValue[2]-lastIndexValue[0])*(lastIndexValue[3]-lastIndexValue[1]);

           area+=(currentArea-commonArea);
           area=area%((Math.pow(10,9))+7);
            lastIndexValue=currentIndexValue;

        }

        return (int)(area%((Math.pow(10,9))+7));

    }


    Comparator<int[]> getComparator(){
       return  ((int[] o1, int[] o2)-> {
            //@Override
            //public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){

                    if(o1[1]==o2[1]){

                        if(o1[2]==o2[2]){

                            return ((Integer)o1[3]).compareTo((Integer)o2[3]);
                        }
                        else {
                            return ((Integer)o1[2]).compareTo((Integer)o2[2]);
                        }
                    }
                    else {
                        return ((Integer)o1[1]).compareTo((Integer)o2[1]);
                    }
                }
                else {
                    return ((Integer)o1[0]).compareTo((Integer)o2[0]);
                }
           // }
        });
    }


}
