/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }
    public StringBuilder serial(StringBuilder sb, TreeNode root) {
        if(root == null) return sb.append("#");
        sb.append(root.val).append(',');
        serial(sb, root.left).append(',');
        serial(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserial(nodes);
    }
    
    private TreeNode deserial(Queue<String> q){
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));