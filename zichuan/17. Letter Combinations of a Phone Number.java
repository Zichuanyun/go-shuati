class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        // corner case
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[] cArr = new char[digits.length()];
        generate(digits, 0, cArr, res);
        
        return res;
    }
    
    private void generate(String str, int idx, char[] cArr, List<String> res) {
        // stop condition
        if (idx >= str.length()) {
            res.add(new String(cArr));
            return;
        }
        
        // idx < str.length()
        for (char c : getLetters(str.charAt(idx))) {
            cArr[idx] = c;
            generate(str, idx + 1, cArr, res);
        }
    }
    
    private char[] getLetters(char c) {
        char[] res = null;
        switch(c) {
            case '2':
                res = new char[] {'a','b','c'};
                break;
            case '3':
                res = new char[] {'d','e','f'};
                break;
            case '4':
                res = new char[] {'g','h','i'};
                break;
            case '5':
                res = new char[] {'j','k','l'};
                break;
            case '6':
                res = new char[] {'o','m','n'};
                break;
            case '7':
                res = new char[] {'p','q','r','s'};
                break;
            case '8':
                res = new char[] {'t','u','v'};
                break;
            case '9':
                res = new char[] {'w','x','y','z'};
                break;
            default:
                break;
        }
        return res;
    }
}