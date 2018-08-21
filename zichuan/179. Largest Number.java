class Solution {
    
    public String largestNumber(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) return "";
        String[] str_nums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            str_nums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(str_nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //ab > ba => -1
                //ab.compareTo(ba) ab > ba => +1
                return (b + a).compareTo(a + b);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str_nums.length; i++) {
            sb.append(str_nums[i]);
        }
        String str = sb.toString();
        if(str.charAt(0) == '0') return "0";
        else return str;
    }
    
    public String largestNumber2(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) return "";
        PriorityQueue<String> pq = new PriorityQueue<String>(nums.length, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.charAt(0) - a.charAt(0);
            }
        });
        for(Integer n : nums) {
            pq.offer(n.toString());
        }
        String res = "";
        for(; pq.size() > 0; res += pq.poll());
        
        return res;
    }
}
