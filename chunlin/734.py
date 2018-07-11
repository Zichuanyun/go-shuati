class Solution(object):
    def areSentencesSimilar(self, words1, words2, pairs):
        """
        :type words1: List[str]
        :type words2: List[str]
        :type pairs: List[List[str]]
        :rtype: bool
        """
        if len(words1) != len(words2):
            return False
        word_map = dict()
        for pair in pairs:
            if pair[0] not in word_map:
                word_map[pair[0]] = list()
            if pair[1] not in word_map:
                word_map[pair[1]] = list()
            word_map[pair[0]].append(pair[1])
            word_map[pair[1]].append(pair[0])
        for i in range(len(words1)):
            word1 = words1[i]
            word2 = words2[i]
            if word1 == word2:
                continue
            if word1 not in word_map or word2 not in word_map[word1]:
                return False
        return True 
    # error 1: dict of key, list, not key value
    # error 2: need to check if word in dict
