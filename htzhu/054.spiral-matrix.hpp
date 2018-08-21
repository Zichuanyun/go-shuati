class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if(matrix.empty() || matrix[0].empty()) return {};
        int row_begin = 0, row_end = matrix.size() - 1;
        int col_begin = 0, col_end = matrix[0].size() - 1;
        vector<int> ans;
        while(row_begin <= row_end && col_begin <= col_end) {
            for(int j = col_begin; j <= col_end; j++)
                ans.push_back(matrix[row_begin][j]);
            row_begin++;
            for(int i = row_begin; i <= row_end; i++)
                ans.push_back(matrix[i][col_end]);
            col_end--;
            if(row_begin <= row_end) {
                for(int j = col_end; j >= col_begin; j--)
                    ans.push_back(matrix[row_end][j]);
                row_end--;
            }
            if(col_begin <= col_end) {
                for(int i = row_end; i >= row_begin; i--)
                    ans.push_back(matrix[i][col_begin]);
                col_begin++;
            }
        }
        return ans;
    }
};
