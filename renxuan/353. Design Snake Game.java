public class SnakeGame {
    Set<Integer> grid;
    int width, height;
    LinkedList<Integer> snake;
    int head;
    int[][] food;
    int foodIdx;
    int score;
 
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        grid = new HashSet<>();
        snake = new LinkedList<>();
        snake.add(0);
        head = 0;
        grid.add(0);
        this.food = food;
        foodIdx = 0;
        score = 0;
    }
     
    public int move(String direction) {
        char dir = direction.charAt(0);
        int nextX = head / width;
        int nextY = head % width;
        nextX += (dir == 'U') ? -1 : 0;
        nextX += (dir == 'D') ? 1 : 0;
        nextY += (dir == 'L') ? -1 : 0;
        nextY += (dir == 'R') ? 1 : 0;
        if (gameOver(nextX, nextY)) {
            return -1;
        }
        int next = nextX * width + nextY;
        if (foodIdx < food.length && food[foodIdx][0] * width + food[foodIdx][1] == next) {
            score += 1;
            foodIdx += 1;
        } else {
            grid.remove(snake.poll());
        }
        grid.add(next);
        snake.add(next);
        head = next;
        return score;
    }
     
    private boolean gameOver(int nextX, int nextY) {
        if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) {
            return true;
        }
        int tail = snake.peek();
        int next = nextX * width + nextY;
        if (grid.contains(next) && next != tail) {
            return true;
        }
        return false;
    }
}
 
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
