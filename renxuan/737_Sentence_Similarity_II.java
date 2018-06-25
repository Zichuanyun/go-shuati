public class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, String> union = new HashMap<>();
        for(String word : words1) union.put(word, word);
        for(String word : words2) union.put(word, word);
        
        for (List<String> pair : pairs) {
            String first = find(union, pair.get(0));
            String second = find(union, pair.get(1));
            union.put(second, first);
        }
        
        for (int i = 0; i < words1.length; ++i) {
            if (!find(union, words1[i]).equals(find(union, words2[i])))
                return false;
        }

        return true;
    }
    
    String find(Map<String, String> union, String s) {
        if(s.equals(union.get(s))) return s;
        union.put(s, find(union, union.get(s)));
        return union.get(s);
    }
}
