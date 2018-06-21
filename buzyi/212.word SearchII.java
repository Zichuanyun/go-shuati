class Solution {
/*
Prefix tree to avoid words that share prefix (e.g. "aaaaaaaaab" and "aaaaaaaaac").
*/

public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    
    TrieNode root = buildTrie(words);
    for(int i = 0; i< board.length; i++){
        for(int j =0; j< board[0].length; j++){
            dfs(board,i,j,root,res);
        }
    }
    return res;
  }

public void dfs(char[][] board,int i,int j,TrieNode node,List<String> res){
    if(i<0 || i>=board.length || j < 0 || j >= board[0].length){
        return;
    }
    char c = board[i][j];
    if(c == '#'|| node.child[c-'a'] == null){
        return;
    }
    
    node = node.child[c - 'a'];
    if(node.word != null){
        res.add(node.word);
        node.word = null;
    }
    board[i][j] = '#';   //Avoid visited board, use specific character
    dfs(board,i-1,j,node,res);
    dfs(board,i+1,j,node,res);
    dfs(board,i,j-1,node,res);
    dfs(board,i,j+1,node,res);
    board[i][j]=c;
}

public TrieNode buildTrie(String[] words){
    TrieNode root = new TrieNode();
    for(String word : words){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(node.child[i] == null){
                node.child[i] = new TrieNode();
            }
            node = node.child[i];
        }
        node.word = word;
    }
    return root;
}

class TrieNode{
    TrieNode[] child;
    String word;
    public TrieNode(){
        child = new TrieNode[26];
    }
    }
}
