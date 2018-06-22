class Solution {
  /** BFS solution. */
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> queue = new LinkedList<>();

    queue.add(start);
    while (!queue.isEmpty()) {
      int[] point = queue.remove();

      if (visited[point[0]][point[1]]) {
        continue;
      }
      visited[point[0]][point[1]] = true;

      if (Arrays.equals(point, destination)) {
        return true;
      }

      // get all neighbor
      for (int[] direction : directions) {
        int steps = 0;
        // keep on going until reaches a wall or the border of maze
        while (true) {
          int nextX = point[0] + (steps + 1) * direction[0];
          int nextY = point[1] + (steps + 1) * direction[1];
          if (nextX >= maze.length
              || nextY >= maze[0].length
              || nextX < 0
              || nextY < 0
              || maze[nextX][nextY] == 1) {
            break;
          } else {
            steps++;
          }
        }

        if (steps == 0) {
          continue;
        }

        int[] neighbor =
            new int[] {point[0] + steps * direction[0], point[1] + steps * direction[1]};
        queue.add(neighbor);
      }
    }

    return false;
  }
}
