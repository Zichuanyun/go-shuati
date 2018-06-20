class Solution {
public:
    //bellman ford.
    //just run it k+1 iterations.
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dist, int k) {
        vector<int> cur(n, 1e8);
        cur[src] = 0;
        
        for (int i=0; i<=k; i++){
            vector<int> next(cur);
            for (const auto& flight: flights)
                next[flight[1]] = min(next[flight[1]], cur[flight[0]] + flight[2]);
            cur = next;
        }
        return cur[dist] == 1e8 ? -1 : cur[dist];
    }
};
