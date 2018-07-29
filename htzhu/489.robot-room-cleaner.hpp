/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *   public:
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     void turnLeft();
 *     void turnRight();
 *
 *     // Clean the current cell.
 *     void clean();
 * };
 */
struct pair_hash {
    size_t operator () (const pair<int, int> &pr) const {
        return (size_t)pr.first << 32 | pr.second;
    }
};

class Solution {
    const int dirs[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
public:
    void cleanRoom(Robot& robot) {
        unordered_set<pair<int, int>, pair_hash> memo;
        dfs(0, 0, 0, memo, robot);
    }
    void dfs(int r, int c, int face, unordered_set<pair<int, int>, pair_hash> &memo, Robot &robot) {
        if(memo.count({r, c})) return;
        memo.emplace(r, c);
        robot.clean();
        for(int i = 0; i < 4; i++, robot.turnRight(), face = (face + 1) % 4) {
            if(robot.move()) {
                int x = r + dirs[face][0];
                int y = c + dirs[face][1];
                dfs(x, y, face, memo, robot);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
        }
    }
};
