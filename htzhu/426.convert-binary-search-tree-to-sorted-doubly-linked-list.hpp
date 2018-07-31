/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node() {}

    Node(int _val, Node* _left, Node* _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node *prev = NULL, *head = NULL;
public:
    Node* treeToDoublyList(Node* root) {
        if(!root) return NULL;
        dfs(root);
        head->left = prev;
        prev->right = head;
        return head;
    }
    void dfs(Node *node) {
        if(!node) return;
        dfs(node->left);
        if(!head) {
            head = node;
        }
        node->left = prev;
        if(prev) {
            prev->right = node;
        }
        prev = node;
        dfs(node->right);
    }
};
