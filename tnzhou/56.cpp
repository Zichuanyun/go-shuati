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
    static bool cmp(Interval a, Interval b) {
        return a.start < b.start;
    }
    
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        int current_left = -1;
        int current_right = -1;
        vector<Interval> result;
        if (intervals.size() == 0) {
            return result;
        }
        current_left = intervals[0].start;
        current_right = intervals[0].end;
        for (int i = 1; i < intervals.size(); i ++) {
            Interval itv = intervals[i];
            if (itv.start <= current_right && itv.end >= current_left) {
                current_left = min(itv.start, current_left);
                current_right = max(itv.end, current_right);
            } else {
                result.push_back(Interval(current_left, current_right));
                current_left = itv.start;
                current_right = itv.end;
            }
        }
        result.push_back(Interval(current_left, current_right));
        return result;
    }
};
