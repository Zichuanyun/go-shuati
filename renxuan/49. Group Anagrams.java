class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            List<String> set = map.get(key);
            set.add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()) {
            List<String> tmp = new ArrayList<>();
            List<String> set = map.get(key);
            for(String s : set) {
                tmp.add(s);
            }
            res.add(tmp);
        }
        return res;
    }
}
