class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for(char c : digits.toCharArray()) {
            List<String> newList = new ArrayList<>();
            for(String s : res) {
                for(char i : dict[c - '2'].toCharArray()) {
                    newList.add(s + i);
                }
            }
            res = newList;
        }
        return res.size() == 1 ? new ArrayList<>() : res;
    }
}
