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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        auto dummy = new ListNode(0);
        dummy->next = head;
        ListNode *cur = head, *prev = dummy;
        for(int i = 0; i < m - 1; i++){
            prev = cur;
            cur = cur->next;
        }
        auto q = cur, p = cur->next;
        for(int i = 0; i < n - m; i++) {
            auto tmp = p->next;
            p->next = q;
            q = p;
            p = tmp;
        }
        prev->next = q;
        cur->next = p;
        return dummy->next;
    }
};
