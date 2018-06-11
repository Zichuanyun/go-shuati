class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        HashMap<Character, Integer> sourceHash = new HashMap<>();
        HashMap<Character, Integer> targetHash = new HashMap<>();
        for (Character c : t.toCharArray()) {
            if (!targetHash.containsKey(c)) {
                targetHash.put(c, 1);
            } else {
                targetHash.put(c, targetHash.get(c) + 1);
            }
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!validate(sourceHash, targetHash) && j < s.length()) {
                char c = s.charAt(j);
                if (!sourceHash.containsKey(c)) {
                    sourceHash.put(c, 1);
                } else {
                    sourceHash.put(c, sourceHash.get(c) + 1);
                }
                j++;    // forgot, TLE
            }
            if (validate(sourceHash, targetHash)) {
                if (j - i < minLen) {
                    minLen = j - i;
                    minStr = s.substring(i, j);
                }
            }
            char d = s.charAt(i);
            sourceHash.put(d, sourceHash.get(d) - 1);
            if (sourceHash.get(d) == 0) {
                sourceHash.remove(d);
            }
        }
        return minStr;
        
    }
    private boolean validate(HashMap<Character, Integer> source,
                             HashMap<Character, Integer> target) {
        for (Character c : target.keySet()) {
            if (!source.containsKey(c)) {
                return false;
            }
            if (source.get(c) < target.get(c)) {
                return false;
            }
        }
        return true;
    }
}
