class Solution {    
    public int findCircleNum(int[][] M) {
        int[] root = new int[M.length];
        for(int i = 0; i < M.length; i ++) {
            root[i] = -1;
        }
        for(int i = 0; i < M.length; i ++) {
            for(int j = 0; j < M.length; j ++) {
                if(M[i][j] == 1) {
                    int x = findroot(i, root);
                    int y = findroot(j, root);
                    if( x != y) {
                        root[x] = y;
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < root.length; i++) {
            set.add(findroot(i, root));
        }
        return set.size();
    }
    public int findroot(int r, int[] root) {
        if(root[r] != -1) {
            return root[r] = findroot(root[r], root);
        } else {
            return r;
        }        
    }
}