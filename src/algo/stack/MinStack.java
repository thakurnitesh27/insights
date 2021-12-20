package stack;

import java.util.Stack;

public class MinStack {

    /*
    ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(-2147483646);
        stack.push(2147483646);
        System.out.println("Min: "+stack.getMin());
        stack.push((2147483647));
        System.out.println("Min: "+stack.getMin());
        stack.pop();
        System.out.println("Min: "+stack.getMin());
        stack.pop();
        System.out.println("Min: "+stack.getMin());
        stack.pop();

        stack.push(2147483647);
        System.out.println("Min: "+stack.getMin());
        stack.pop();
        stack.push(-2147483648);
        System.out.println("Min: "+stack.getMin());
        stack.pop();
        System.out.println("Min: "+stack.getMin());

    }
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        if(val<=min){
            min=val;
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
      int val=  stack.peek();
      if(val==min){
         int poppedVal= minStack.pop();
         if(!minStack.empty()) {
             min = minStack.peek();
         }
         else {
             min=Integer.MAX_VALUE;
         }
      }
      stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
