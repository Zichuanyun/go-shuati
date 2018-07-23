class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char t : tasks) {
            ++map[t - 'A'];
        }
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < 26; ++i)
            if(map[i] != 0) q.offer(map[i]);
        int res = 0;
        while(!q.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            int idle = 0;
            while(idle <= n) {
                if(!q.isEmpty()) {
                    int top = q.poll();
                    if(top > 1) {
                        next.add(top - 1);
                    }
                }
                ++res;
                if (q.isEmpty() && next.size() == 0)
                    break;
                ++idle;
            }
            for(int i : next) q.offer(i);
        }
        return res;
    }
}
