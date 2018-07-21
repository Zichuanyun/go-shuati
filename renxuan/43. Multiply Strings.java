class Solution {
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];
        for(int i  =num1.length() - 1; i >= 0; --i){
            for(int j = num2.length() - 1; j >= 0; --j){
                int tmp = ans[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i + j] += tmp/10;
                ans[i + j + 1] = tmp % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int p : ans) {
            if(!(sb.length() == 0 && p == 0)) 
                sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
