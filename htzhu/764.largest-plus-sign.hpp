#define INF INT_MAX

struct pair_hash {
    size_t operator () (const pair<int, int> &pr) const {
        return (size_t)pr.first << 32 | pr.second;
    }
};

class Solution {
public:
    int orderOfLargestPlusSign(int N, vector<vector<int>>& mines) {
        vector<vector<int>> res(N, vector<int>(N, INF));
        unordered_set<pair<int, int>, pair_hash> zeros;
        for(auto &mine: mines) {
            zeros.emplace(mine[0], mine[1]);
        }
        for(int i = 0; i < N; i++) {
            int j = 0, k = 0;
            while(k < N && zeros.count({i, k})) k++;
            j = k;
            while(j < N) {
                while(k < N && !zeros.count({i, k})) k++;
                for(int l = j; l < k; l++) {
                    res[i][l] = min(res[i][l], min(l - j + 1, k - l));
                }
                while(k < N && zeros.count({i, k})) k++;
                j = k;
            }
        }
        for(int i = 0; i < N; i++) {
            int j = 0, k = 0;
            while(k < N && zeros.count({k, i})) k++;
            j = k;
            while(j < N) {
                while(k < N && !zeros.count({k, i})) k++;
                for(int l = j; l < k; l++) {
                    res[l][i] = min(res[l][i], min(l - j + 1, k - l));
                }
                while(k < N && zeros.count({k, i})) k++;
                j = k;
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(res[i][j] != INF)
                    ans = max(ans, res[i][j]);
        return ans;
    }
};
