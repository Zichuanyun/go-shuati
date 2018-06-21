class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)  return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            int i = top[0];
            int j = top[1];
            if (i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
                rooms[i - 1][j] = rooms[i][j] + 1;
                queue.offer(new int[]{i - 1, j});
            }
            if(j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
                rooms[i][j - 1] = rooms[i][j] + 1;
                queue.offer(new int[]{i, j - 1});
            }
            if(i + 1 < m && rooms[i + 1][j] == Integer.MAX_VALUE) {
                rooms[i + 1][j] = rooms[i][j] + 1;
                queue.offer(new int[]{i + 1, j});
            }
            if(j + 1 < n && rooms[i][j + 1] == Integer.MAX_VALUE) {
                rooms[i][j + 1] = rooms[i][j] + 1;
                queue.offer(new int[]{i, j + 1});
            }
        }
    }
}