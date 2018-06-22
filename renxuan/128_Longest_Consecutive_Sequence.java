class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int res = 0;
        for(int num : nums) {
            if(left.containsKey(num) || right.containsKey(num))
                continue;
            int l = left.getOrDefault(num - 1, num);
            int r = right.getOrDefault(num + 1, num);
            left.put(r, l); left.put(num, l);
            right.put(l, r); right.put(num, r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
