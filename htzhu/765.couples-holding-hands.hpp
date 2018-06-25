class Solution {
public:
    int minSwapsCouples(vector<int>& row) {
        int n = row.size();
        vector<int> pos(n);
        for(int i = 0; i < n; i++)
            pos[row[i]] = i;
        int ans = 0;
        for(int i = 0; i < n; i += 2) {
            int cp = row[i] ^ 1;
            if(row[i+1] == cp) continue;
            ans++;
            pos[row[i+1]] = pos[cp];
            swap(row[i+1], row[pos[cp]]);
        }
        return ans;
    }
};
