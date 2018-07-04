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
    void reorderList(ListNode* head) {
        if(!head || !head->next) return;
        auto slow = head, fast = head, prev = head;
        while(fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        prev->next = NULL;
        auto head2 = reverseList(slow);
        mergeList(head, head2);
    }
    ListNode *reverseList(ListNode *head) {
        if(!head || !head->next) return head;
        auto res = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return res;
    }
    ListNode *mergeList(ListNode *p, ListNode *q) {
        if(!p) return q;
        if(!q) return p;
        auto tmp = p->next;
        p->next = q;
        q->next = mergeList(tmp, q->next);
        return p;
    }
};
