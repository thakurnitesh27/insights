package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class NextSmallerElement {
    public static void main(String[] args) {
       // print( new NextSmallerElement().findNextSmaller(new int[]{4, 5, 2, 10, 8}));
        print( new NextSmallerElement().findNextSmaller(new int[]{3,2,1}));
    }
  static void print(int[] arr){
      Arrays.stream(arr).forEach(a-> System.out.print(a+" , "));
  }
   int[] findNextSmaller(int [] arr){
        int invalidCase=-1;
        int[] r=new int[arr.length];
       Stack<Integer> s=new Stack();
       s.push(arr[0]);
       r[0]=invalidCase;

       for(int i=1;i<arr.length;i++){

           int currElement=arr[i];
           boolean found=false;
           int item=invalidCase;
           while (!found) {
                item = s.peek();
               if (item >= currElement) {
                   s.pop();
               }
               else {
                   r[i]=item;
                   found=true;
               }
               if(s.empty() && !found){
                   item=invalidCase;
                  found=true;
               }
           }
           s.push(arr[i]);
           r[i]=item;
       }

       return r;
    }

}
