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
    ListNode* reverseKGroup(ListNode* head, int k) {
        auto dummy = new ListNode(0), cur = dummy;
        auto p = head, q = head;
        while(p) {
            for(int i = 0; i < k - 1 && q; i++, q = q->next);
            if(!q) {
                cur->next = p;
                break;
            }
            auto tmp = q->next;
            q->next = NULL;
            cur->next = reverseList(p);
            cur = p;
            p = q = tmp;
        }
        return dummy->next;
    }
    ListNode *reverseList(ListNode *head) {
        if(!head || !head->next) return head;
        auto res = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return res;
    }
};
