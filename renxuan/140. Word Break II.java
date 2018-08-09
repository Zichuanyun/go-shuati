class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }
    
    List<String> DFS(String s, List<String> wordDict, HashMap<String, List<String>>map) {
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for(String sub : subList)
                    res.add(word + (sub.length() == 0 ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
