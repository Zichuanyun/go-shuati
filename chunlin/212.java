class Solution {
    public int[] toX = {0, 0, -1, 1};
    public int[] toY = {-1, 1, 0, 0};
    public int m, n;
    public boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        visited = new boolean[m][n];
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (trie.root.map.containsKey(c)) {
                    helper(trie.root, board, i, j, result);
                }
            }
        }
        return result;
    }
    private void helper(TrieNode node, char[][] board, int i, int j, List<String> result) {
        if (node.isEnd && !result.contains(node.str)) {     // check duplicate  
            result.add(node.str);
            // return; 
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !node.map.containsKey(board[i][j])) {
            return;
        }
        visited[i][j] = true;
        char ch = board[i][j];
        for (int k = 0; k < 4; k++) {       // k > 4 ????????
            int nextX = i + toX[k];
            int nextY = j + toY[k];
            helper(node.map.get(ch), board, nextX, nextY, result);
        }
        visited[i][j] = false;
    }
}
class TrieNode {
    public boolean isEnd;
    public String str;
    public HashMap<Character, TrieNode> map;
    public TrieNode() {
        str = "";
        isEnd = false;
        map = new HashMap<>();
    }
}
class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                cur.map.put(c, newNode);
                cur = newNode;
            } else {
                cur = cur.map.get(c);
            }
        }
        cur.isEnd = true;
        cur.str = word;
    }
    
}
