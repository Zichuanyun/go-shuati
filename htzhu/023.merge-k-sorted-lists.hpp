/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()) return NULL;
        int n = lists.size();
        while(n > 1) {
            int i = 0;
            for(int j = 0; j < n; j += 2) {
                if(j + 1 < n) {
                    lists[i++] = merge(lists[j], lists[j+1]);
                } else {
                    lists[i++] = lists[j];
                }
            }
            n = i;
        }
        return lists[0];
    }
    ListNode *merge(ListNode *p, ListNode *q) {
        if(!p) return q;
        if(!q) return p;
        if(p->val > q->val) swap(p, q);
        p->next = merge(p->next, q);
        return p;
    }
};
