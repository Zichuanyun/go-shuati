/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {         // Null exception, forgot to check
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        HashSet<UndirectedGraphNode> nodeSet = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        nodeSet.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!nodeSet.contains(neighbor)) {
                    queue.offer(neighbor);
                    nodeSet.add(neighbor);
                }
            }
        }
        
        for (UndirectedGraphNode cur: nodeSet) {
            map.put(cur, new UndirectedGraphNode(cur.label));
        }
        for (UndirectedGraphNode cur: nodeSet) {
            for (UndirectedGraphNode nei: cur.neighbors) {
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        
        return map.get(node);
        
    }
}
