package main.leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks { Stack<Integer> myStack;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        myStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        recurr(x);
    }

    private void recurr(int x){
        if(myStack.isEmpty()){
            myStack.push(x);
            return;
        }

        int item = myStack.pop();
        recurr(x);
        myStack.push(item);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return myStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return myStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return myStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */