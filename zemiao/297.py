# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        
        # return: [len(map), [tuple(val,leftIndex,rightIndex)] ]
        if not root:
          return ""
        map = {}
        nodeCount = [0]
        def populate(root):
          item = [root.val,-1,-1]
          if root.left:
            populate(root.left)
            item[1] = nodeCount[0]
          if root.right:
            populate(root.right)
            item[2] = nodeCount[0]
          nodeCount[0] += 1
          map[nodeCount[0]] = item
        
        populate(root)
        res = [len(map)]
        for _,v in map.items():
          res += v
        return str(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
          return None
        
        data = data[1:-1]
        def getList(s):
          tmp = ""
          res = []
          for c in s:
            if c != ',':
              tmp = tmp+c
            else:
              res.append(int(tmp))
              tmp = ""
          res.append(int(tmp))
          return res
        
        d = getList(data)
        n = d[0]
        map, nodeMap = {}, {}
        for i in range(n):
          map[i+1] = d[1+3*i:1+3*(i+1)]
          nodeMap[i+1] = TreeNode(map[i+1][0])
        for i in range(n):
          if map[i+1][1] != -1:
            nodeMap[i+1].left = nodeMap[map[i+1][1]]
          if map[i+1][2] != -1:
            nodeMap[i+1].right = nodeMap[map[i+1][2]]
        return nodeMap[n]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))