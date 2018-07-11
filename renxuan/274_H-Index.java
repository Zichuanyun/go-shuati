class Solution {
    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        for(int c : citations) {
            if(c >= citations.length) ++bucket[citations.length];
            else ++bucket[c];
        }
        int h = citations.length, tmp = 0;
        for(; h >= 0; --h) {
            tmp += bucket[h];
            if(tmp >= h) break;
        }
        return h;
    }
}
