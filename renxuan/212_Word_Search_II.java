class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.word = word;
    }
    
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(String word : words)
            insert(word);
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                dfs(res, board, root, i, j);
            }
        }
        return res;
    }
    
    private void dfs(List<String> res, char[][] board, TrieNode node, int row, int col) {
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        char ch = board[row][col];
        if(ch > 128 || node.children[ch - 'a'] == null)
            return;
        node = node.children[ch - 'a'];
        board[row][col] ^= 128;
        dfs(res, board, node, row + 1, col);
        dfs(res, board, node, row - 1, col);
        dfs(res, board, node, row, col + 1);
        dfs(res, board, node, row, col - 1);
        board[row][col] ^= 128;
    }
}