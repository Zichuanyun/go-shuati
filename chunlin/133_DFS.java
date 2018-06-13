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
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        helper(node, map);
        return map.get(node);
    }
    
    private void helper(UndirectedGraphNode node,
                       HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        map.put(node, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode nei: node.neighbors) {
            if (!map.containsKey(nei)) {
                helper(nei, map);
            }
            map.get(node).neighbors.add(map.get(nei));
        }
    }
}
