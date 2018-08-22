class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int tank = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                ans = i + 1;
            }
        }
        if(ans == n) return -1;
        tank = 0;
        for(int i = 0; i < n; i++) {
            int j = (ans + i) % n;
            tank += gas[j] - cost[j];
            if(tank < 0) {
                return -1;
            }
        }
        return ans;
    }
};
