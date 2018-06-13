class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if(M.size()==0 || M[0].size()==0) return 0;
        int res = 0;
        queue<int> tmp;
        for(int i=0; i<M.size(); i++) {
            for(int j=0; j<M[0].size(); j++) {
                if(M[i][j]==1) {
                    res++;
                    tmp.push(i);
                    tmp.push(j);
                    M[i][j]=0;
                    M[j][i]=0;
                    while(!tmp.empty()) {
                        int tmpElemt = tmp.front();
                        tmp.pop();
                        for(int k=0; k<M[0].size(); k++) {
                            if(M[tmpElemt][k]==1) {
                                tmp.push(k);
                                M[tmpElemt][k]=0;
                                M[k][tmpElemt]=0;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
};
