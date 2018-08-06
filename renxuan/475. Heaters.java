class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heaterSet = new TreeSet<>();
        for(int h : heaters) heaterSet.add(h);
        long dist = 0;
        for(int h : houses) {
            long ceiling = (heaterSet.ceiling(h) == null)? Integer.MAX_VALUE : heaterSet.ceiling(h);
            long floor = (heaterSet.floor(h) == null)? Integer.MIN_VALUE : heaterSet.floor(h);
            dist = Math.max(dist, Math.min(ceiling - h, h - floor));
        }
        return (int)dist;
    }
}
