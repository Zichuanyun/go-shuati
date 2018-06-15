public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] list = new boolean[s.length() + 1];
        list[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(list[j] && dict.contains(s.substring(j,i))) {
                    list[i] = true;
                    break;
                }
            }
        }
        return list[s.length()];
    }
}