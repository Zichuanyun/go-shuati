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
        auto &itvs = intervals;
        sort(itvs.begin(), itvs.end(), [](const auto &lhs, const auto &rhs) {
                                           return lhs.start < rhs.start;
                                       });
        int n = itvs.size();
        for(int i = 1; i < n; i++) {
            if(itvs[i].start < itvs[i-1].end) return false;
        }
        return true;
    }
};
