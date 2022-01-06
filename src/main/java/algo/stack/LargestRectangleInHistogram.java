package algo.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

//        System.out.println(new LargestRectangleInHistogram().maxAreaUsing2Array(
//                new int[]{6,2,5,4,5,1,6}
//        ));
//        System.out.println(new LargestRectangleInHistogram().maxAreaUsing2Array(
//                new int[]{2,4}
//        ));
                System.out.println(new LargestRectangleInHistogram().maxAreaUsing2Array(
                new int[]{1,2,2}
        ));
//        System.out.println(new LargestRectangleInHistogram().maxAreaUsing2Array(
//                new int[]{5,5,1,7,1,1,5,2,7,6}
//        ));
//        System.out.println(new LargestRectangleInHistogram().largestArea2(
//                new int[]{2,1,5,6,2,3}
//        ));
    }

    int largestAreaNaive( int[] arr){
        int max_height=0;

        for(int i=0;i<arr.length;i++){
            int sum=0;
            int curr_height=arr[i];

            for(int j=0;j<arr.length;j++){

                if(j>i && sum==0){
                    break;
                }

                if(sum>max_height){
                    max_height=sum;
                }

                if(arr[j]>=curr_height){
                    sum+=curr_height;
                }
                else {
                    sum=0;
                }

            }
        }

        return max_height;

    }
    int largestAreaNaive2( int[] arr){
        int max_height=0;

        for(int i=0;i<arr.length;i++){

            int curr_height=arr[i];
            int sum=curr_height;

            int j=i-1;
            while (j>=0){

                if(arr[j]>=curr_height){
                    sum+=curr_height;
                }
                else {
                    break;
                }
                j--;
            }
            j=i+1;
            while (j<arr.length){
                if(arr[j]>=curr_height){
                    sum+=curr_height;
                }
                else {
                    break;
                }
                j++;
            }

            if(sum>max_height){
                max_height=sum;
            }


        }

        return max_height;

    }

    int maxAreaUsing2Array(int[] arr){

        int left_min[]=new int[arr.length];
        int right_min[]=new int[arr.length];

        Stack<Integer> s=new Stack<>();
        s.push(0);
      //  left_min[0]=-1;
        //int j=1;

        for(int f=0;f<arr.length;f++){
            left_min[f]=-1;
            right_min[f]=arr.length;
        }
      //  for(int i=1;i<arr.length;i++){
        int i=1;
        while (i<=arr.length-1){

            int curr_element=arr[i];
            int e=-1;

            while (!s.isEmpty()){


               if(arr[s.peek()]<curr_element){
                  // left_min[i]=e;
                  // right_min[j]=curr_element;
                  // j++;
                   e=s.peek();
                   break;
               }
               else {
                   if(arr[s.peek()]>curr_element && right_min[s.peek()]==arr.length){
                       right_min[s.peek()]=i;
                   }
                   if(arr[s.peek()]!=curr_element) {
                       s.pop();
                   }
                   else {
                      // left_min[i]=left_min[s.peek()];
                       e=left_min[s.peek()];
                       break;
                   }
                  // j--;
               }


            }
            left_min[i]=e;
           // right_min[j]=curr_element;
            s.push(i);
            //j++;

            i++;

        }

        int max_area=arr[0];

        for(int k=0;k<arr.length;k++){

            int area=arr[k]*(right_min[k]-left_min[k]-1);
            if(area>max_area){
                max_area=area;
            }
        }
        return max_area;

    }

    int maxArea(int[]hist){
        int n=hist.length;
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }
}
