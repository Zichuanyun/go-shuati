class TrieNode(object):
  def __init__(self):
    self.next = [None for _ in range(26)]
    self.isLeaf = False
    self.weight = -1
    
  def insert(self, word, weight):
    node = self
    for c in word:
      i = ord(c)-ord('a')
      if not node.next[i]:
        node.next[i] = TrieNode()
      node = node.next[i]
    node.isLeaf = True
    node.weight = weight
  
  def lookup(self, prefix):
    node = self
    for c in prefix:
      node = node.next[ord(c)-ord('a')]
      if not node:
        return None
    return node

class WordFilter(object):

  def __init__(self, words):
    """
    :type words: List[str]
    """
    self.root, self.reversedRoot = TrieNode(),TrieNode()
    for i in range(len(words)):
      self.root.insert(words[i],i)
      self.reversedRoot.insert(words[i][::-1],i)
    self.map = {}

  def f(self, prefix, suffix):
    """
    :type prefix: str
    :type suffix: str
    :rtype: int
    """
    wP, wS = self.getWeights(self.root,prefix), self.getWeights(self.reversedRoot,suffix)
    if not (wP and wS):
      return -1
    
    s1 = set(wP)
    s1.intersection_update(set(wS))
    return max(s1) if s1 else -1

  def getWeights(self, root, prefix):
    t = (root==self.root, prefix)
    if t in self.map:
      return self.map[t]
    
    res = []
    node = root.lookup(prefix if t[0] else prefix[::-1])
    if not node:
      return []
    
    stack = [node]
    while stack:
      temp = stack.pop()
      if temp.isLeaf:
        res.append(temp.weight)
      for n in temp.next:
        if n:
          stack.append(n)
    self.map[t] = res
    return res

# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(prefix,suffix)