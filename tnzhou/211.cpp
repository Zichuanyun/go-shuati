class WordDictionary {
public:
    WordDictionary *child[26];
    bool wordEnd;

    /** Initialize your data structure here. */
    WordDictionary() {
        for (int i = 0; i < 26; i ++)
            child[i] = nullptr;
        wordEnd = false;
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        WordDictionary *curNode = this;
        for (int i = 0; i < word.length(); i++) {
            int cIndex = word[i] - 'a';
            if (curNode->child[cIndex] == nullptr) {
                curNode->child[cIndex] = new WordDictionary();
            }
            curNode = curNode->child[cIndex];
        }
        curNode->wordEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        return dfsSearch(this, word);
    }

private:
    bool dfsSearch(WordDictionary *curNode, string restStr) {
        if (restStr.length() == 0)
            return curNode->wordEnd;
        if (restStr[0] == '.') {
            // All way search
            string remainedStr = restStr.substr(1);
            for (int i = 0; i < 26; i++) {
                if (curNode->child[i] != nullptr && dfsSearch(curNode->child[i], remainedStr))
                    return true;
            }
        } else {
            int cIndex = restStr[0] - 'a';
            if (curNode->child[cIndex] == nullptr) {
                return false;
            } else {
                return dfsSearch(curNode->child[cIndex], restStr.substr(1));
            }
        }
        return false;
    }    
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */
