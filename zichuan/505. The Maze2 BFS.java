public class Solution {
    private int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] newStart = queue.remove();
            for (int[] dir : dirs) {
                int x = newStart[0];
                int y = newStart[1];
                int count = -1;
                do {
                    x += dir[0];
                    y += dir[1];
                    count++;
                } while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0);
                if (distance[newStart[0]][newStart[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[newStart[0]][newStart[1]] + count;
                    queue.add(new int[] { x - dir[0], y - dir[1] });
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
                : distance[destination[0]][destination[1]];
    }
}