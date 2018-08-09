class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int n = A.length;
        HashMap<Integer, Integer>[] mapArray = new HashMap[A.length];
        for(int i = 0; i < n; i++) {
            mapArray[i] = new HashMap<Integer, Integer>();
            for(int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
                
                int d = (int)diff;
                int c1 = mapArray[i].getOrDefault(d, 0);
                int c2 = mapArray[j].getOrDefault(d, 0);
                
                mapArray[i].put(d, c1 + c2 + 1);
                res += c2;
            }   
        }
        return res;
    }
}
