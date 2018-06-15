class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = {}
        self.isLeaf = False

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        if word == "":
            self.isLeaf = True
            return
        c = word[0]
        if c not in self.map:
            self.map[c] = Trie()
        self.map[c].insert(word[1:])

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        if word == "":
            return self.isLeaf
        c = word[0]
        if c not in self.map:
            return False
        return self.map[c].search(word[1:])

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        if prefix == "":
            return True
        c = prefix[0]
        if c not in self.map:
            return False
        return self.map[c].startsWith(prefix[1:])


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)