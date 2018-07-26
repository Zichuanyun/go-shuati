/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        stringstream ss;
        serializeHelper(root, ss);
        return ss.str();
    }
    void serializeHelper(TreeNode *node, stringstream &ss) {
        if(!node) {
            ss << "# ";
            return;
        }
        ss << node->val;
        ss << ' ';
        serializeHelper(node->left, ss);
        serializeHelper(node->right, ss);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        return deserializeHelper(ss);
    }
    TreeNode* deserializeHelper(stringstream &ss) {
        string s;
        ss >> s;
        if(s == "#") return NULL;
        else {
            auto node = new TreeNode(stoi(s));
            node->left = deserializeHelper(ss);
            node->right = deserializeHelper(ss);
            return node;
        }
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
