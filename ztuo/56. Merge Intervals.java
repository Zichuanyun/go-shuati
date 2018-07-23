/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if(intervals == null || intervals.size() < 1) return res;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        Interval prev = null;
        for (Interval current : intervals) {
            if (prev == null || current.start > prev.end) {
                res.add(current);
                prev = current;
            } else if (current.end > prev.end) {
                prev.end = current.end;
            }
        }
        
        return res;
    }
}