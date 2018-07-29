class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap();
        for(List<Integer> row : wall) {
            int sum = 0;
            for(int i = 0; i < row.size() - 1; ++i) {
                sum += row.get(i);
                if(!map.containsKey(sum)) map.put(sum, 0);
                map.put(sum, map.get(sum) + 1);
            }
        }
        int min = wall.size(), n = wall.size();
        for(int v : map.values()) {
            min = Math.min(min, n - v);
        }
        return min;
    }
}
