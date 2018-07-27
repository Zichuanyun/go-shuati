class Solution {
public:
    int minCostII(vector<vector<int>>& costs) {
        vector<int> lowestTotal;
        vector<int> lowestColor;
        vector<int> secondTotal;
        vector<int> secondColor;
        int n = costs.size();
        if (n == 0)
            return 0;
        int k = costs[0].size();
        if (k == 0)
            return 0;
        int mincost = 0;
        int mincolor = -1;
        int secondcost = 0;
        int secondcolor = -1;
        for (int j = 0; j < k; j++) {
            if (costs[0][j] < mincost || mincolor == -1) {
                mincost = costs[0][j];
                mincolor = j;
            } 
        }
        for (int j = 0; j < k; j++) {
            if (j != mincolor) {
                if (costs[0][j] < secondcost || secondcolor == -1) {
                    secondcost = costs[0][j];
                    secondcolor = j;
                }
            }
        }
        cout << mincolor << ":" << mincost << "; " << secondcolor << ":" << secondcost <<endl;
        lowestTotal.push_back(mincost);
        lowestColor.push_back(mincolor);
        secondTotal.push_back(secondcost);
        secondColor.push_back(secondcolor);
        for (int i = 1; i < n; i++) {
            mincost = 0;
            mincolor = -1;
            for (int j = 0; j < k; j++) {
              if (j != lowestColor[i - 1] && (mincolor == -1 || costs[i][j] + lowestTotal[i - 1] < mincost)) {
                mincost = costs[i][j] + lowestTotal[i - 1];
                mincolor = j;
              } else if (j != secondColor[i - 1]  && (mincolor == -1 || costs[i][j] + secondTotal[i - 1] < mincost)) {
                mincost = costs[i][j] + secondTotal[i - 1];
                mincolor = j;
              }
            }
            secondcost = 0;
            secondcolor = -1;
            for (int j = 0; j < k; j++) {
                if (j != mincolor) {
                  if (j != lowestColor[i - 1] && (secondcolor == -1 || costs[i][j] + lowestTotal[i - 1] < secondcost)) {
                    secondcost = costs[i][j] + lowestTotal[i - 1];
                    secondcolor = j;
                  } else if (j != secondColor[i - 1] && (secondcolor == -1 || costs[i][j] + secondTotal[i - 1] < secondcost)) {
                    secondcost = costs[i][j] + secondTotal[i - 1];
                    secondcolor = j;
                  }
                }
            }
            if (secondcolor == -1)
                return 2147483647;
            lowestTotal.push_back(mincost);
            lowestColor.push_back(mincolor);
            secondTotal.push_back(secondcost);
            secondColor.push_back(secondcolor);
            cout << mincolor << ":" << mincost << "; " << secondcolor << ":" << secondcost <<endl;
        }
        return lowestTotal[n - 1];
    }
};
