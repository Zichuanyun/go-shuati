class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.connect(edge[0], edge[1]);
        }
        return uf.getCount();
    }
    class UnionFind {
        private int[] father;
        private int count;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
            count = n;
        }
        public int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);         // find(x)
        }
        public void connect(int x, int y) {
            int root_x = find(x);   // father[x]
            int root_y = find(y);
            if (root_x != root_y) {
                father[root_x] = root_y;
                count--;
            }
        }
        public int getCount() {
            return count;
        }
       
    }
}
