class NumMatrix {
    vector<vector<int>> A, C;
    int m, n;
public:
    NumMatrix(vector<vector<int>> matrix) {
        if(matrix.empty() || matrix[0].empty()) return;
        m = matrix.size(), n = matrix[0].size();
        A = vector<vector<int>>(m, vector<int>(n));
        C = vector<vector<int>>(m + 1, vector<int>(n + 1));
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                update(i, j, matrix[i][j]);
    }
    
    void update(int row, int col, int val) {
        int diff = val - A[row][col];
        A[row][col] = val;
        for(int r = row + 1; r <= m; r += r & (-r)) {
            for(int c = col + 1; c <= n; c += c & (-c)) {
                C[r][c] += diff;
            }
        }
    }

    int query(int row, int col) {
        int sum = 0;
        for(int r = row + 1; r > 0; r -= r & (-r)) {
            for(int c = col + 1; c > 0; c -= c & (-c)) {
                sum += C[r][c];
            }
        }
        return sum;
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2, col2) - query(row1 - 1, col2) - query(row2, col1 - 1) + query(row1 - 1, col1 - 1);
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
