class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int state = 0;
        for (int i = 0; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (state == 0) {
                if (cur.end < newInterval.start) {
                    res.add(cur);
                } else {
                    state = 1;
                    int start = Math.min(cur.start, newInterval.start);
                    while (i < intervals.size()) {
                        if (newInterval.end >= intervals.get(i).start) {
                            ++i;
                        } else {
                            break;
                        }
                    }
                    if (i != 0) {
                        --i;
                        cur = intervals.get(i);
                        int end = Math.max(cur.end, newInterval.end);
                        res.add(new Interval(start, end));
                    } else {
                        res.add(newInterval);
                    }
                }
            } else {
                res.add(cur);
            } 
        }
        if (state == 0) {
            res.add(newInterval);
        }
        return res;
    }
}