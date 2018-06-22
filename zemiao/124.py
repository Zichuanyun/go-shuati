# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def maxPathSumAndMaxSubtreeSum(node):
            if not node:
                return None, None
            
            ans_left, ans_sub_left = None, None
            if node.left:
                ans_left, ans_sub_left = maxPathSumAndMaxSubtreeSum(node.left)
            
            ans_right, ans_sub_right = None, None
            if node.right:
                ans_right, ans_sub_right = maxPathSumAndMaxSubtreeSum(node.right)
                
            # Need handle case of empty subtree
            # Need handle case of negative subtree: max(subtree,0)+val)
            # Need handle case of negative node.val: max(subtree+val, 0)
            if ans_left and ans_right:
                ans = max(ans_left, ans_right, ans_sub_left+ans_sub_right+node.val)
                ans_sub = max(max(ans_sub_left, ans_sub_right, 0)+node.val, 0)
            elif ans_left:
                ans = max(ans_left, ans_sub_left+node.val)
                ans_sub = max(max(ans_sub_left, 0)+node.val, 0)
            elif ans_right:
                ans = max(ans_right, ans_sub_right+node.val)
                ans_sub = max(max(ans_sub_right, 0)+node.val, 0)
            else:
                ans = node.val
                ans_sub = max(node.val, 0)

            return ans, ans_sub
        
        return maxPathSumAndMaxSubtreeSum(root)[0]