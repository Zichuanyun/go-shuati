class Solution {
    private int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public boolean hasPath(int[][] board, int[] start, int[] destination) {
    Set<Pos> set = new HashSet<>();
    return dfs(board,set,new Pos(start[0],start[1]),new Pos(destination[0],destination[1]));
}

private boolean dfs(int[][] board,Set<Pos> set,Pos pos,Pos destination){
    if(set.contains(pos)){
        return false;
    }
    
    if(pos.equals(destination)){
        return true;
    }
    
    set.add(pos);
    for(int[] dir : dirs){
        int childRow = pos._i;
        int childCol = pos._j;
        
        while(childRow >=0 && childRow < board.length && childCol >=0 && childCol < board[0].length && board[childRow][childCol] == 0){
            childRow += dir[0];
            childCol += dir[1];
        }
       
        childRow -= dir[0];
        childCol -= dir[1];
        if(dfs(board,set,new Pos(childRow,childCol),destination)){
            return true;
        }
    }
    return false;
}
}
