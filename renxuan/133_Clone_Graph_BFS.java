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
        if(node == null) return null;
        List<UndirectedGraphNode> queue = new ArrayList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int count = 0;
        while(count < queue.size()) {
            UndirectedGraphNode head = queue.get(count++);
            for(UndirectedGraphNode neighbor : head.neighbors) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        for( UndirectedGraphNode originalNode : queue) {
            UndirectedGraphNode correspondingNode = map.get(originalNode);
            for(UndirectedGraphNode neighbor : originalNode.neighbors) {
                correspondingNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}