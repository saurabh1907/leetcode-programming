# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root: TreeNode, currSum: int) -> bool:
        if(root is None):
            return

        if root.left == None and root.right is None:
            if((currSum - root.val) is 0):
                return True
            else:
                return False

        return self.hasPathSum(root.left, currSum - root.val) or self.hasPathSum(root.right, currSum - root.val)

        