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
    vector<vector<int>> verticalOrder(TreeNode* root) {
        unordered_map<int, vector<int>> mp;
        queue<pair<TreeNode *, int>> q;
        if(!root) return {};
        q.emplace(root, 0);
        int leftCol = INT_MAX, rightCol = INT_MIN;
        while(!q.empty()) {
            auto &pr = q.front(); 
            auto node = pr.first;
            int col = pr.second;
            q.pop();
            mp[col].push_back(node->val);
            leftCol = min(leftCol, col);
            rightCol = max(rightCol, col);
            if(node->left) {
                q.emplace(node->left, col - 1);
            }
            if(node->right) {
                q.emplace(node->right, col + 1);
            }
        }
        vector<vector<int>> ans;
        for(int i = leftCol; i <= rightCol; i++) {
            ans.push_back(mp[i]);
        }
        return ans;
    }
};
