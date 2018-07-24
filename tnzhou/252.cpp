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
    bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        if (intervals.size() == 0)
            return true;
        for (int i = 1; i < intervals.size(); i ++) {
            if (intervals[i - 1].end > intervals[i].start)
                return false;
        }
        return true;
    }
    
    static bool cmp(Interval &a, Interval &b) {
        return a.start < b.start;
    }
};
