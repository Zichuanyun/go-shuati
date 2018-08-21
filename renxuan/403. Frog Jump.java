class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length <= 1) return true;
        int dest = stones[stones.length - 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1);
        for(int stone : stones) {
            for(int step : map.get(stone)) {
                int next = stone + step;
                if(next == dest) return true;
                if(!map.containsKey(next)) continue;
                Set<Integer> nextSet = map.get(next);
                if(step > 1) nextSet.add(step - 1);
                nextSet.add(step);
                nextSet.add(step + 1);
            }
        }
        return false;
    }
}
