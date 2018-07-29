/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
struct Line {
    int x, val;
    Line(int x, int val): x(x), val(val) {}
    bool operator < (const Line &line) const {
        return x < line.x || x == line.x && val < line.val;
    }
};

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<Line> lines;
        for(auto &itv: intervals) {
            lines.emplace_back(itv.start, 1);
            lines.emplace_back(itv.end, -1);
        }
        sort(lines.begin(), lines.end());
        int ans = 0;
        int cur = 0;
        for(auto &line: lines) {
            cur += line.val;
            ans = max(ans, cur);
        }
        return ans;
    }
};
