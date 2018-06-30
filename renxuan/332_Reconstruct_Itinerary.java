class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        List<String> res = new ArrayList<>();
        Stack<String> s = new Stack<>();
        s.push("JFK");
        while(!s.empty()) {
            String top = s.peek();
            while(map.containsKey(top) && map.get(top).size() > 0) {
                s.push(map.get(top).poll());
                top = s.peek();
            }
            res.add(0, s.pop());
        }
        return res;
    }
}
