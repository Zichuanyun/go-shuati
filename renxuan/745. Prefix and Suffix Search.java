class WordFilter {
    class TrieNode {
        List<String> words;
        Map<String, Integer> weight;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
            words = new ArrayList<>();
            weight = new HashMap<>();
        }
    }

    TrieNode root;
    
    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode node = root;
            node.words.add(word);
            node.weight.put(word, i);
            for(char c : word.toCharArray()) {
                if(node.children[c - 'a'] == null) 
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
                node.words.add(word);
                node.weight.put(word, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if(node.children[c - 'a'] == null) return -1;
            node = node.children[c - 'a'];
        }
        for(int i = node.words.size() - 1; i >= 0; --i) {
            String word = node.words.get(i);
            if(word.endsWith(suffix)) return node.weight.get(word);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
 