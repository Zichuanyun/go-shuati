class Solution {
public:
    int maxProfit(int k, vector<int> &prices) {
        int len = prices.size();
        if (len<2) return 0;
        if (k>len/2){ // simple case
            int ans = 0;
            for (int i=1; i<len; ++i){
                ans += max(prices[i] - prices[i-1],0);
            }
            return ans;
        }
        int hold[k+1];
        int rele[k+1];
        for (int i=0;i<=k;++i){
            hold[i] = INT_MIN;
            rele[i] = 0;
        }
        int cur;
        for (int i=0; i<len; ++i){
            cur = prices[i];
            for(int j=k; j>0; --j){
                rele[j] = max(rele[j],hold[j] + cur);//
                hold[j] = max(hold[j],rele[j-1] - cur);
            }
            for(int j=k; j>0; --j){
                cout << rele[j] << " ";
            }   
            cout << endl;
            for(int j=k; j>0; --j){
                cout << hold[j] << " ";
            }   
            cout << endl;
        }
        return rele[k];
    }
};
