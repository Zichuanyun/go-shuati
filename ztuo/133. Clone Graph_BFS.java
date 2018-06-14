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
        if (node == null) return null;
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label); 
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); 
        
        map.put(clone.label, clone);         
        LinkedList<UndirectedGraphNode> queue = new LinkedList(); 
        queue.add(node);
        
        while (!queue.isEmpty()) { 
            UndirectedGraphNode n = queue.pop();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        return clone;
    }
}