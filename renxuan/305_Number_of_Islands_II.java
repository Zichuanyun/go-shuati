/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        if(operators == null || operators.length == 0)
            return new ArrayList<>();
        int islands = 0;
        int[] union = new int[m * n];
        Arrays.fill(union, -1);
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(Point op : operators) {
            int r = op.x, c = op.y;
            int curr = r * n + c;
            if(set.contains(curr)) {
                res.add(islands);
                continue;
            }
            set.add(curr);
            union[curr] = curr;
            ++islands;
            for(int[] dir : dirs) {
                int nextR = r + dir[0], nextC = c + dir[1];
                int next = nextR * n + nextC;
                if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || union[next] == -1)
                    continue;
                while(union[next] != next) {
                    union[next] = union[union[next]];
                    next = union[next];
                }
                if(curr == next) continue;
                union[next] = curr;
                --islands;
            }
            res.add(islands);
        }
        return res;
    }
}