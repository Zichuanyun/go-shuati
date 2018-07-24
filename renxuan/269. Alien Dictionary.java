public class Solution {
    public String alienOrder(String[] words) {
        boolean[] appear = new boolean[26];
        Set<Character>[] predecessor = new Set[26];
        for(int i = 0; i < 26; ++i) predecessor[i] = new HashSet<>();
        int differentChar = 0;
        for(String word : words) {
            char[] charArray = word.toCharArray();
            for(int i = 0; i < charArray.length - 1; ++i) {
                if(!appear[charArray[i] - 'a']) {
                    appear[charArray[i] - 'a'] = true;
                    ++differentChar;
                }
                if(!appear[charArray[i + 1] - 'a']) {
                    appear[charArray[i + 1] - 'a'] = true;
                    ++differentChar;
                }
            }
        }
        for(int i = 0; i < words.length - 1; ++i) {
            int firstDiff = 0;
            while(firstDiff < words[i].length() && firstDiff < words[i + 1].length() && words[i].charAt(firstDiff) == words[i + 1].charAt(firstDiff)) ++firstDiff;
            if(firstDiff < words[i].length() && firstDiff < words[i + 1].length()) {
                if(!appear[words[i].charAt(firstDiff) - 'a']) {
                    appear[words[i].charAt(firstDiff) - 'a'] = true;
                    ++differentChar;
                }
                if(!appear[words[i + 1].charAt(firstDiff) - 'a']) {
                    appear[words[i + 1].charAt(firstDiff) - 'a'] = true;
                    ++differentChar;
                }
                if(predecessor[words[i].charAt(firstDiff) - 'a'].contains(words[i + 1].charAt(firstDiff))) {
                    return "";
                }
                predecessor[words[i + 1].charAt(firstDiff) - 'a'].add(words[i].charAt(firstDiff));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(differentChar-- > 0) {
            Character nextChar = null;
            for(int i = 0; i < 26; ++i) {
                if(appear[i] && predecessor[i].size() == 0) {
                    appear[i] = false;
                    nextChar = (char)('a' + i);
                    sb.append(nextChar);
                    break;
                } 
            }
            if(nextChar == null) {
                return "";
            }
            for(int i = 0; i < 26; ++i) {
                predecessor[i].remove(nextChar);
            }
        }
        return sb.toString();
    }
}
