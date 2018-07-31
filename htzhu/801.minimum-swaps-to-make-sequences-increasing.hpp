class Solution {
public:
    int minSwap(vector<int>& A, vector<int>& B) {
        int swapDp = 1, fixDp = 0;
        for(int i = 1; i < A.size(); i++) {
            if(A[i-1] >= B[i] || B[i-1] >= A[i]) {
                swapDp++;
            } else if(A[i-1] >= A[i] || B[i-1] >= B[i]) {
                int tmp = fixDp;
                fixDp = swapDp;
                swapDp = tmp + 1;
            } else {
                int minDp = min(fixDp, swapDp);
                fixDp = minDp;
                swapDp = minDp + 1;
            }
        }
        return min(fixDp, swapDp);
    }
};
