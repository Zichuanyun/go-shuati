/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int res = 0, cnt = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        for(Interval it : intervals) {
            pq.offer(new int[]{it.start, 0});
            pq.offer(new int[]{it.end, 1});
        }
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            if(top[1] == 0) {
                ++cnt;
                res = Math.max(res, cnt);
            }
            else --cnt;
        }
        return res;
    }
}
