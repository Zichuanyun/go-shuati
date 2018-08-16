class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        String res = new String();
        for(String s : strs) res += s;
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index++;
        }
        if (index == res.length()) {
            return "0";
        }
        return res.substring(index);
    }
}
