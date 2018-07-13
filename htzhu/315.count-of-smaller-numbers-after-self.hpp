struct Node {
    int val, cnt;
    Node *left = NULL, *right = NULL;
    Node(int val, int cnt):val(val), cnt(cnt) {}
};

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        Node *root = NULL;
        for(int i = nums.size() - 1; i >= 0; i--) {
            root = insert(root, nums[i], ans[i]);
        }
        return ans;
    }
    Node *insert(Node *node, int val, int &sum) {
        if(!node) return new Node(val, 1);
        if(val > node->val) {
            sum += node->cnt;
            node->right = insert(node->right, val, sum);
        } else {
            node->cnt++;
            node->left = insert(node->left, val, sum);
        }
        return node;
    }
};
