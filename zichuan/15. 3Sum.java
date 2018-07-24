class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if(nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
                while(low < high) {
                    if(nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[low], nums[i], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] > sum) {
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        high--;
                    } else {
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        low++;
                    }
                }
            }
        }
        
        return res;
        
    }
        /*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if(nums == null || nums.length < 3) return res;
        //Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        Set<List<Integer>> res_set = new HashSet();
        
        for(int i = 0; i < nums.length ; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                Integer[] tri = new Integer[3];
                tri[0] = nums[i];
                tri[1] = nums[j];
                tri[2] = 0 - tri[0] - tri[1];
                if(map.containsKey(tri[2])) {
                    int count = map.get(tri[2]);
                    if(tri[2] == tri[0]) count--;
                    if(tri[2] == tri[1]) count--;
                    if(count > 0) {
                        Arrays.sort(tri);
                        List<Integer> t = Arrays.asList(tri);
                        res_set.add(t);  
                    }
                }
            }
        }
        
        for(List<Integer> list : res_set) {
            res.add(list);
        }
        
        return res;
    }
    */
}