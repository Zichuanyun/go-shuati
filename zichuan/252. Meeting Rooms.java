class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        //corner case
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i + 1].start < intervals[i].end) return false;
        }
        return true;
    }
}