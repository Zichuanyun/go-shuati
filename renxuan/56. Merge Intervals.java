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
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Interval it = null;
        for(int i = 0; i < intervals.size(); ++i) {
            Interval tmp = intervals.get(i);
            if(it == null) it = tmp;
            else if(tmp.start <= it.end) {
                it.start = Math.min(it.start, tmp.start);
                it.end = Math.max(it.end, tmp.end);
            }
            else {
                res.add(new Interval(it.start, it.end));
                it = tmp;
            }
        }
        res.add(new Interval(it.start, it.end));
        return res;
    }
}
