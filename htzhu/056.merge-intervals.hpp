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
    vector<Interval> merge(vector<Interval>& intervals) {
        auto &itvs = intervals;
        if(itvs.empty()) return {};
        sort(itvs.begin(), itvs.end(), [](const auto &lhs, const auto &rhs) {
                                                     return lhs.start < rhs.start;
                                                 });
        int n = itvs.size();
        int i = 0;
        for(int j = 0; j < n; j++) {
            if(itvs[j].start <= itvs[i].end) {
                itvs[i].end = max(itvs[i].end, itvs[j].end);
            } else {
                i++;
                itvs[i].start = itvs[j].start;
                itvs[i].end = itvs[j].end;
            }
        }
        itvs.resize(i + 1);
        return itvs;
    }
};
