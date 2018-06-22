/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        if(!root) return {};
        vector<int> path;
        vector<string> ans;
        dfs(root, path, ans);
        return ans;
    }
    void dfs(TreeNode *node, vector<int> &path, vector<string> &ans) {
        path.push_back(node->val);
        if(!node->left && !node->right) {
            string s = to_string(path[0]);
            for(int i = 1; i < path.size(); i++) {
                s += "->";
                s += to_string(path[i]);
            }
            ans.push_back(s);
        } else {
            if(node->left) {
                dfs(node->left, path, ans);
            }
            if(node->right) {
                dfs(node->right, path, ans);
            }
        }
        path.pop_back();
    }
};
