class Solution{
public int numIslands(char[][] a) {
    // corner case
    if (a.length == 0 || a[0].length == 0) return 0;
int count = 0;
boolean[][] visited = new boolean[a.length][a[0].length];
for (int i = 0; i < a.length; ++i) {
    for (int j = 0; j < a[0].length; ++j) {
    if (a[i][j] == '1' && !visited[i][j]) {
        ++count;
        dfs(a, visited, i, j);
}
}
}
return count;

}

private void dfs(char[][] a, boolean[][] visited, int x, int y) {
    visited[x][y] = true;
    for (int i = 0; i < 4; ++i) {
        int newX = x + dirs[i][0];
int newY = y + dirs[i][1];
if (newX < 0 || newX >= a.length || newY < 0 || newY >= a[0].length || a[newX][newY] == '0' || visited[newX][newY]) {
    continue;
}
dfs(a, visited, newX, newY);
}
}

int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
