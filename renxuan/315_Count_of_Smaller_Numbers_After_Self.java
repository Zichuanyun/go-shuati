class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(), sorted = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; --i) {
            int pos = insertPos(sorted, nums[i]);
            res.add(0, pos);
            sorted.add(pos, nums[i]);
        }
        return res;
    }
    
    private int insertPos(List<Integer> list, int num) {
        int l = 0, r = list.size();
        while(l < r) {
            int m = l + (r - l)/2;
            if(list.get(m) >= num) {
                r = m;
            }
            else l = m + 1;
        }
        return l;
    }
}
