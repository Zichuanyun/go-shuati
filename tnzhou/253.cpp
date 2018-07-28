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
    int minMeetingRooms(vector<Interval>& intervals) {
        unordered_map <int, int> m;
        vector<int> timePoints;
        for (int i = 0; i < intervals.size(); i++) {
            timePoints.push_back(intervals[i].start);
            timePoints.push_back(intervals[i].end);
            m[intervals[i].start]++;
            m[intervals[i].end]--;
        }
        sort(timePoints.begin(), timePoints.end());
        int maxCnt = 0;
        int cnt = 0;
        for (int i = 0; i < timePoints.size(); i++) {
            if (i == 0 || timePoints[i] != timePoints[i - 1]) {
                cnt += m[timePoints[i]];
                if (cnt > maxCnt)
                    maxCnt = cnt;
            }
        }
                                
        return maxCnt;                        
    }
};
