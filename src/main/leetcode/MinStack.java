package main.leetcode;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    Stack<Long> stack = new Stack<>();
    Stack<Long> minStack = new Stack<>();
    Long min = Long.MAX_VALUE;
    public MinStack() {

    }

    public void push(int x) {
        if(minStack.isEmpty() || x <= min){
            minStack.push(Long.valueOf(x));
            min = Long.valueOf(x);
        }
        stack.push(Long.valueOf(x));

    }

    public void pop() {
        if(stack.isEmpty())
            return;
        Long item = stack.peek();
        stack.pop();
        if(item <= minStack.peek()){
            minStack.pop();
            if(minStack.isEmpty())
                min = Long.MIN_VALUE;
            else
                min = minStack.peek();
        }

    }

    public long top() {
        return stack.peek();
    }

    public long getMin() {
        return minStack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */