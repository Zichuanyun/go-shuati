class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isSegmentOk = new boolean[s.length() + 1];
        isSegmentOk[0] = true; // none of char
            for (int i = 1; i < s.length() + 1; i++) {
                int j = i - 1;
                while (j >= 0) {
                    if (isSegmentOk[j] == true && wordDict.contains(s.substring(j, i))) {
                        isSegmentOk[i] = true;
                        break;
                    } else {
                        j--;
                    }
                }
            }
        return isSegmentOk[s.length()];
    }
}
