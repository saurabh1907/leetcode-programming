package main.leetcode;

import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return true;

        TreeNode node1;
        TreeNode node2;

        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            node1 = stack.pop();
            node2 = stack.pop();
            if(node1==null && node2==null)
                continue;
            else if(node1!=null && node2!=null && node1.val==node2.val){
                stack.push(node2.left);
                stack.push(node1.right);
                stack.push(node2.right);
                stack.push(node1.left);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
