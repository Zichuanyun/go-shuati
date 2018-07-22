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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode top = q.poll();
            if(top == null) sb.append('#');
            else {
                sb.append(top.val);
                q.offer(top.left);
                q.offer(top.right);
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.charAt(0) == '#') return null;
        String[] parts = s.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while(i < parts.length) {
            TreeNode top = q.poll();
            if(!parts[i].equals("#")) {
                top.left = new TreeNode(Integer.valueOf(parts[i]));
                q.offer(top.left);
            }
            ++i;
            if(!parts[i].equals("#")) {
                top.right = new TreeNode(Integer.valueOf(parts[i]));
                q.offer(top.right);
            }
            ++i;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
