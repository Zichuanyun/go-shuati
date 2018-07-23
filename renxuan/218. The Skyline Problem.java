class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (height1, height2) -> {
            if(height1[0] == height2[0]) return height1[1] - height2[1];
            return height1[0] - height2[0];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        for(int[] h : height) {
            if(h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]);
            int curr = pq.peek();
            if(prev != curr) {
                result.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        
        return result;
    }
}
