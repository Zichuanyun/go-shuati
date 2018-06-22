class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>(); // <from, [[to0, price0], [to1, price1], ...]>
        for (int[] flight : flights) {
            int s = flight[0], t = flight[1], p = flight[2];
            List<int[]> list = map.get(s);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(new int[]{t, p});
            map.put(s, list);
        }        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
        	int[] top = pq.poll();
        	int totalPrice = top[0], pos = top[1], stop = top[2];
        	if(pos == dst) return totalPrice;
        	if(stop > K || !map.containsKey(pos)) continue;
        	List<int[]> list = map.get(pos);
            for(int[] dstAndPrice : list) {
                int d = dstAndPrice[0], p = dstAndPrice[1];
                pq.offer(new int[] {totalPrice + p, d, stop + 1});
            }
        }
        return -1;
    }
}