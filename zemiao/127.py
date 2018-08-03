from collections import deque

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """ 
        if endWord not in wordList:
          return 0
        
        Q = deque()
        search = set(wordList)
        Q.append((beginWord,1))
        while Q:
          tmp,level = Q.popleft()
          if tmp==endWord:
            return level
          for i in range(len(tmp)):
            for c in 'abcdefghijklmnopqrstuvwxyz':
              newWord = tmp[:i]+c+tmp[i+1:]
              if newWord in search:
                search.discard(newWord)
                Q.append( (newWord,level+1) )
        return 0