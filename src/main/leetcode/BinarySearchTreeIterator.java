package main.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {
    Queue<Integer> queue = new LinkedList();
    public BinarySearchTreeIterator(TreeNode root) {
        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);
        queue.add(root.val);
        inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (queue.peek()!=null) ? true:false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */