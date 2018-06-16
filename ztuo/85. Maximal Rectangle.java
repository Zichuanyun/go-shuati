class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return 0;         
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int[] height = new int[cLen+1];
        height[cLen]=0;
        int max = 0;
               
        for (int i = 0; i < rLen; i++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0;j < cLen + 1; j++) {
                if (j < cLen)
                    if(matrix[i][j] == '1') {
                        height[j] += 1; 
                    }
                    else height[j] = 0;
                if (s.isEmpty() || height[s.peek()] <= height[j])
                    s.push(j);
                else {
                    while(!s.isEmpty() && height[j] < height[s.peek()]){
                        int top = s.pop();
                        max = Math.max(max, height[top] * (s.isEmpty() ? j: (j - s.peek()-1)));                       
                    }
                    s.push(j);
                }
            }
        }
        return max;
    }
}