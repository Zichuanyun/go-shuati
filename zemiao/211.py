class TrieNode(object):
  def __init__(self):
    self.vals = [None]*26
    self.isLeaf = False
    
  def search(self,word):
    if not word:
      return self.isLeaf
    c = word[0]
    if c == '.':
      for node in self.vals:
        if not node:
          continue
        if node.search(word[1:]):
          return True
      return False
    if not self.vals[ord(c)-ord('a')]:
      return False
    else:
      return self.vals[ord(c)-ord('a')].search(word[1:])

class WordDictionary(object):

  def __init__(self):
    """
    Initialize your data structure here.
    """
    self.root = TrieNode()

  def addWord(self, word):
    """
    Adds a word into the data structure.
    :type word: str
    :rtype: void
    """
    node = self.root
    for c in word:
      if not node.vals[ord(c)-ord('a')]:
        node.vals[ord(c)-ord('a')] = TrieNode()
      node = node.vals[ord(c)-ord('a')] 
    node.isLeaf = True

  def search(self, word):
    """
    Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    :type word: str
    :rtype: bool
    """
    return self.root.search(word)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)