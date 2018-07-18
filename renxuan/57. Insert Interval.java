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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0, n = intervals.size();
        while(i < n && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            ++i;
        }
        while(i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            ++i;
        }
        res.add(newInterval);
        while(i < n) {
            res.add(intervals.get(i));
            ++i;
        }
        return res;
    }
}
