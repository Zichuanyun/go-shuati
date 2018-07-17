class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        map = {}
        for word in strs:
          key = [0]*26
          for c in word:
            key[ord(c)-ord('a')] += 1
          t = tuple(key)
          if t in map:
            map[t].append(word)
          else:
            map[t] = [word]
        return map.values()