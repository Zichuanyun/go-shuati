class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s == null || t == null) {
            return result;
        }
        Map<Character, Integer> dict = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(dict.containsKey(t.charAt(i))){
                dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
            } else {
                dict.put(t.charAt(i), 1);
            }
        }
        int start = 0; int leftNum = t.length();
        for (int i = 0; i < s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {
                if (dict.get(s.charAt(i)) > 0) {
                    leftNum--;
                }
                dict.put(s.charAt(i), dict.get(s.charAt(i)) - 1);                
            }
            if (leftNum == 0) {
                start = shrink(s, dict, start, i);
                String tempBest = s.substring(start, i+1);
                result = result==null || result.length()==0 ||result.length()>tempBest.length() ? tempBest : result;
            }
        }
        return result;        
    }
    private int shrink(String s,  Map<Character, Integer> dict, int start, int end) {
        
        while(start < end) {
                char ch = s.charAt(start);
                if (dict.containsKey(ch)) {
                    if(dict.get(ch) < 0) {
                        dict.put(ch, dict.get(ch)+1);
                    } else{
                        return start;
                    }
                }
                start ++;
        }
        return start;
    }
}