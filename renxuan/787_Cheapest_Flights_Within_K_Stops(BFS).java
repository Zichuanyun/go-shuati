class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Queue<int[]> q = new LinkedList<>(); // [[pos1, stops1, totalprice1], [src2, stops2, totalprice2], ...]
        Map<Integer, List<int[]>> map = new HashMap<>(); // <from, [[to0, price0], [to1, price1], ...]>
        int res = -1;
        for(int[] flight : flights) {
            int s = flight[0], t = flight[1], p = flight[2];
            List<int[]> list = map.get(s);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(new int[]{t, p});
            map.put(s, list);
        }
        q.offer(new int[]{src, 0, 0});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int s = top[0], stop = top[1], totalPrice = top[2];
            if(stop > K || !map.containsKey(s) || (res != -1 && totalPrice > res)) continue;
            List<int[]> list = map.get(s);
            for(int[] dstAndPrice : list) {
                int d = dstAndPrice[0], p = dstAndPrice[1];
                if(d == dst) {
                    if(res == -1 || totalPrice + p < res)
                        res = totalPrice + p;
                }
                else {
                    q.offer(new int[]{d, stop + 1, totalPrice + p});
                }
            }
        }        
        return res;
    }
}