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
        int current_left = -1;
        int current_right = -1;
        vector<Interval> result;
        bool inserted_new = false;
        if (intervals.size() == 0) {
            result.push_back(newInterval);
            return result;
        }
        int start_pos = 1;
        current_left = intervals[0].start;
        current_right = intervals[0].end;
        if (newInterval.start < current_left) {
            current_left = newInterval.start;
            current_right = newInterval.end;
            inserted_new = true;
            start_pos = 0;
        }
        for (int i = start_pos; i < intervals.size(); i ++) {
            Interval itv = intervals[i];
            if (!inserted_new && newInterval.start <= itv.start) {
                itv = newInterval;
                inserted_new = true;
                i--;
            }
            if (itv.start <= current_right && itv.end >= current_left) {
                current_left = min(itv.start, current_left);
                current_right = max(itv.end, current_right);
            } else {
                result.push_back(Interval(current_left, current_right));
                current_left = itv.start;
                current_right = itv.end;
            }
        }
        if (!inserted_new) {
            Interval itv = newInterval;
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
