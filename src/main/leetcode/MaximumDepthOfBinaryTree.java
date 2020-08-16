package main.leetcode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }

    public int findDepth(TreeNode root){
        if(root == null)
            return 0;

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
