# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.height = -1
        self.parent = None

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        return self.traverse(root,x,y,0, None)

    def traverse(self,root, x,y, level, parent):
        if root is not None:
            if (root.val == x or root.val == y):
                if(self.height == -1):
                    self.height = level
                    self.parent = parent
                elif (level == self.height and parent != self.parent):
                    return True
                else:
                    return False
            else:
                return self.traverse(root.left,x,y, level+1, root) or self.traverse(root.right,x,y, level+1, root)


