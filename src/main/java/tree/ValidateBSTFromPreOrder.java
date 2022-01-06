package tree;

import java.util.Stack;

public class ValidateBSTFromPreOrder {
    public static void main(String[] args) {

    }

    Boolean validate(int [] arr){
        Stack<Integer> stack=new Stack<>();
        //stack.push(arr[0]);

        int i=0;
        int root=Integer.MIN_VALUE;
        while (i<arr.length){

            if(arr[i]<root){
                return false;
            }

            while (!stack.isEmpty() && stack.peek()<arr[i]){

                root= stack.pop();
            }

            stack.push(arr[i]);

        }

        return true;
    }
}
