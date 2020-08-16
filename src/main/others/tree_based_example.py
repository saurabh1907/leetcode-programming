# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    column_table = {}
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        self.column_table = {}
        answer = []
        self.inorder_traverse(root, 0, 10000)
        for i in sorted(self.column_table):
            item_list = self.column_table[i]
            subanswer = []
            for j in sorted(item_list, cmp=self.compare):
                subanswer.append(j[1])
            answer.append(subanswer)
        return answer

    def compare(self, a,b):
        if a[0]<b[0]:
            return -1
        elif a[0]>b[0]:
            return 1
        else:
            if a[1] < b[1]:
                return -1
            elif a[1]>b[1]:
                return 1
            else:
                return 0

    def inorder_traverse(self, root, row, level):
        if(root == None):
            return
        self.inorder_traverse(root.left, row+1, level-1)
        if level not in self.column_table or self.column_table[level] == None:
            self.column_table[level] = []
        self.column_table[level].append((row, root.val))
        self.inorder_traverse(root.right, row+1 ,level +1)

root = TreeNode(1)
left = TreeNode(2)
root.left = left
left = TreeNode(4)
right = TreeNode(5)
root.left.left = left
root.left.right = right

right = TreeNode(3)
root.right = right
left = TreeNode(6)
right = TreeNode(7)
root.right.left = left
root.right.right = right

s= Solution()
print(s.verticalTraversal(root))