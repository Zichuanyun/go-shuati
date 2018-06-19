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
    vector<string> res;
public:
    void record(vector<int> &path) {
        string tmp_res = "";
        if(path.size()==0) return; 
        if(path.size()==1) {
            res.push_back(to_string(path[0]));
            return;
        }
        for(int i=0; i<path.size()-1; i++) {
            tmp_res += to_string(path[i]) + "->";
        }
        tmp_res += to_string(path[path.size()-1]);
        res.push_back(tmp_res);
    }
    void DFS(TreeNode* root, vector<int> &path) {
        if(root==NULL) return;
        path.push_back(root->val);
        if(root->left==NULL && root->right==NULL) record(path);
        DFS(root->left,path);
        DFS(root->right,path);
        path.pop_back();
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<int> path;
        DFS(root,path);
        return res;
    }
};
