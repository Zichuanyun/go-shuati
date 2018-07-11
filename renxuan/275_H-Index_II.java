class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1, res = 0;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(citations[m] >= citations.length - m) {
                res = citations.length - m;
                r = m - 1;
            }
            else l = m + 1;
        }    
        return res;
    }
}
