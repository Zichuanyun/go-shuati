class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String word : wordList)
            dict.add(word);
        if(!dict.contains(endWord))
            return 0;
        List<String> oneLevel = new ArrayList<>();
        oneLevel.add(beginWord);
        dict.remove(beginWord);
        int res = 1;
        while(oneLevel.size() != 0) {
            ++res;
            List<String> nextLevel = new ArrayList<>();
            for(String word : oneLevel) {
                char[] charArray = word.toCharArray();
                for(int i = 0; i < charArray.length; ++i) {
                    char oldChar = charArray[i];
                    for(char c = 'a'; c <= 'z'; ++c) {
                        charArray[i] = c;
                        String newWord = new String(charArray);
                        if(newWord.equals(endWord)) return res;
                        if(dict.contains(newWord)) {
                            nextLevel.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    charArray[i] = oldChar;
                }
                oneLevel = new ArrayList(nextLevel);
            }
        }
        return 0;
    }
}
