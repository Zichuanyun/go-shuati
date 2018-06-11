class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int slow = 0, minlen = Integer.MAX_VALUE, index = 0;
        int matchcount = 0;
        for(int fast = 0; fast < s.length(); fast++){
            char ch = s.charAt(fast);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0) {
                    matchcount++;
                }
                while(matchcount == t.length()){
                    //here is the match
                    if(fast - slow + 1 < minlen){
                        minlen = fast - slow + 1;
                        
                        index = slow;
                    }
                    char sch = s.charAt(slow);

                    if(map.containsKey(sch)){
                        map.put(sch, map.get(sch) + 1);
                        if(map.get(sch) > 0){
                            matchcount--;
                            System.out.println(matchcount);
                        }

                    }
                    slow++;
                }
            }
        }
        if(minlen == Integer.MAX_VALUE) return "";
        // System.out.println(index);
        return s.substring(index, index + minlen);        
    }
}