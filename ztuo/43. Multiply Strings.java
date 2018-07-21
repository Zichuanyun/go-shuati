class Solution {
    public String multiply(String num1, String num2) {
        
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int p2 = i + j;
                int p1 = i + j + 1;
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');// get the multiply of two integers
                int sum = pos[p1] + multiply; // get the new sum 
                pos[p1] = sum % 10;
                pos[p2] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(p != 0 || sb.length() != 0)
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}