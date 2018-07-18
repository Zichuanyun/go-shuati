/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> ans;
        int n = intervals.size();
        int i = 0;
        for(; i < n && intervals[i].end < newInterval.start; i++) ans.push_back(intervals[i]);
        for(; i < n && intervals[i].start <= newInterval.end; i++) {
            auto &itv = intervals[i];
            newInterval.start = min(newInterval.start, itv.start);
            newInterval.end = max(newInterval.end, itv.end);
        }
        ans.push_back(newInterval);
        for(; i < n; i++) ans.push_back(intervals[i]);
        return ans;
    }
};
