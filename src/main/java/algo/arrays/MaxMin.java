package algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxMin {

    public static void main(String[] args) {

        System.out.println(new MaxMin().solve(Arrays.asList(-2, 1, -4, 5, 3)));
    }
    public int solve(List<Integer> A) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){

            int currentValue=A.get(i);
            if(currentValue>max){
                max=currentValue;
            }
            else if(currentValue<min){
                min=currentValue;
            }
        }
        return max+min;
        /*
        [-2, 1, -4, 5, 3]

         */
    }
}
