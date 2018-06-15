class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        m = len(board)
        if m == 0:
            return []
        n = len(board[0])
        seen = [[0]*n for i in range(m)]
        
        # Construct the trie tree.
        s = set()
        def dfs(a,b,temp,trie):
            if a>=m or a<0 or b>=n or b<0 or seen[a][b]:
                return
            
            next = trie.prefix(board[a][b])
            if not next:
                return
            temp += board[a][b]
            if next.isLeaf:
                s.add(temp)
            seen[a][b] = 1
            dfs(a+1,b,temp,next)
            dfs(a-1,b,temp,next)
            dfs(a,b+1,temp,next)
            dfs(a,b-1,temp,next)
            seen[a][b] = 0

        root = Trie()   
        for word in words:
            root.insert(word)
                
        ans = []
        for i in range(m):
            for j in range(n):
                dfs(i,j,"",root);

        for word in s:
            ans.append(word)
        return ans
            
class Trie(object):
    def __init__(self):
        self.array = [None]*26
        self.isLeaf = False

    def insert(self, word):
        if word == "":
            self.isLeaf = True
            return
        c = ord(word[0])-ord('a')
        if not self.array[c]:
            self.array[c] = Trie()
        self.array[c].insert(word[1:])

    def prefix(self, word):
        if word == "":
            return self
        c = ord(word[0])-ord('a')
        if not self.array[c]:
            return None
        return self.array[c].prefix(word[1:])
        