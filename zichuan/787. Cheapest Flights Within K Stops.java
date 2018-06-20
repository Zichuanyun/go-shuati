class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0) return 0;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; ++i) {
            graph[flights[i][0]].add(flights[i]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, src, 0}); // price, curSrc, stops
        
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            //cur: price, src, stops
            if (cur[2] > K + 1) {
                continue;
            }
            if (cur[1] == dst) {
                return cur[0];
            }
            int curK = cur[2] + 1;
            // array: src, dst, price
            for (int[] array : graph[cur[1]]) {
                pq.offer(new int[] {cur[0] + array[2], array[1], curK});
            }
        }
        
        return -1;
    }
}