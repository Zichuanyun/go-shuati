class Solution {
    public String minWindow(String source , String target) {
        if(target.length() == 0) return "";
        String res = "";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> dict = new HashMap<>();
        int effective = 0;
        for(char c : target.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
            ++effective;
        }
        int begin = -1, end = 0;
        while(end < source.length()) {
            while(end < source.length() && effective > 0) {
                char c = source.charAt(end);
                if(dict.containsKey(c)) {
                    if(dict.get(c) > 0)
                        --effective;
                    dict.put(c, dict.get(c) - 1);
                }
                ++end;
            }
            
            while(effective == 0) {
                if(end - begin < min) {
                    min = end - begin;
                    res = source.substring(begin + 1, end);    
                }
                ++begin;
                char c = source.charAt(begin);
                if(dict.containsKey(c)) {
                    if(dict.get(c) >= 0)
                        ++effective;
                    dict.put(c, dict.get(c) + 1);
                }
            }
        }
        
        return res;
    }
}