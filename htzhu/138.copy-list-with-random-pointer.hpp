/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        auto dummy = new RandomListNode(0);
        unordered_map<RandomListNode*, RandomListNode*> node2copy;
        for(auto p = dummy, q = head; q; p = p->next, q = q->next) {
            auto node = new RandomListNode(q->label);
            node2copy[q] = node;
            node->random = q->random;
            p->next = node;
        }
        for(auto p = dummy->next; p; p = p->next) {
            if(p->random)
                p->random = node2copy[p->random];
        }
        return dummy->next;
    }
};
