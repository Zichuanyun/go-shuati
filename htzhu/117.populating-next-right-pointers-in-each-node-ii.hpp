/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(!root) return;
        vector<TreeLinkNode*> lvl, tlvl;
        lvl.push_back(root);
        while(!lvl.empty()) {
            tlvl.clear();
            TreeLinkNode *prev = NULL;
            for(auto node: lvl) {
                for(int i = 0; i < 2; i++) {
                    auto p = (i == 0 ? node->left : node->right);
                    if(p) {
                        if(prev) {
                            prev->next = p;
                        }
                        tlvl.push_back(p);
                        prev = p;
                    }
                }
            }
            lvl.swap(tlvl);
        }
    }
};
