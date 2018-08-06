struct pair_hash {
    size_t operator () (const pair<int, int> &pr) const {
        return ((size_t)pr.first << 32) | pr.second;
    }
};

unordered_map<char, pair<int, int>> dirs =
    {
     {'U', {-1, 0}},
     {'D', {1, 0}},
     {'L', {0, -1}},
     {'R', {0, 1}}
    };

class SnakeGame {
    unordered_set<pair<int, int>, pair_hash> body;
    deque<pair<int, int>> snake;
    vector<pair<int, int>> food;
    int food_index = 0;
    int m, n;
public:
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    SnakeGame(int width, int height, vector<pair<int, int>> food) {
        m = height;
        n = width;
        this->food = decltype(this->food)(food.begin(), food.end());
        body.emplace(0, 0);
        snake.emplace_back(0, 0);
        this->food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    int move(string direction) {
        if(food_index == -1) return -1;
        auto dir = dirs[direction[0]];
        auto head = snake.front();
        int r = head.first + dir.first, c = head.second + dir.second;
        if(r < 0 || r == m || c < 0 || c == n) return food_index = -1;
        pair<int, int> new_head = {r, c};
        if(snake.back() != new_head && body.count(new_head)) return food_index = -1;
        if(food_index < food.size() && food[food_index] == new_head) {
            food_index++;
        } else {
            body.erase(snake.back());
            snake.pop_back();
        }
        body.insert(new_head);
        snake.push_front(new_head);
        return food_index;
    }
};

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
