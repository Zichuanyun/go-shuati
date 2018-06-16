/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        return copy(node);
    }
    
    private UndirectedGraphNode copy(UndirectedGraphNode node){
        if(node == null) return null;
        
        if(m.containsKey(node)){
           return m.get(node); 
        }
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);

        m.put(node, clone);
        
        for(UndirectedGraphNode nextto: node.neighbors){
            clone.neighbors.add(copy(nextto));
        }
        
        return clone;
        
    }
}