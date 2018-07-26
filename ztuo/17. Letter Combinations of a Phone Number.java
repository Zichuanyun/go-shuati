class Solution {
    public List<String> letterCombinations(String digits) {
        
        String buttons[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new LinkedList<>();
        if(digits == null || digits.length() == 0) return result;
        result.add("");
        for(int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            result = combine(index, buttons, result);
        }
        return result;
    }
    private List<String> combine(int index, String[] buttons, List<String> pre) {
        List<String> result = new LinkedList<>();
        char[] candidate = buttons[index].toCharArray();
        for(char c: candidate) {
            for(String s: pre) {
                result.add(s + c);
            }
        }
        return result;
    }
}