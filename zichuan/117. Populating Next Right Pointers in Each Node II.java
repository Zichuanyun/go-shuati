public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur_start = root;
        while (cur_start != null) {
            TreeLinkNode next_start = null;
            TreeLinkNode cur = new TreeLinkNode(-1);
            while (cur_start != null) {
                if (cur_start.left != null) {
                    if (next_start == null) next_start = cur_start.left;
                    cur.next = cur_start.left;
                    cur = cur.next;
                }
                if (cur_start.right != null) {
                    if (next_start == null) next_start = cur_start.right;
                    cur.next = cur_start.right;
                    cur = cur.next;
                }
                cur_start = cur_start.next;
            }
            cur_start = next_start;
        }
    }
}