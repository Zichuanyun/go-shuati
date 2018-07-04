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
    ListNode* partition(ListNode* head, int x) {
        auto ltHead = new ListNode(0), gtHead = new ListNode(0);
        auto p = ltHead, q = gtHead;
        while(head) {
            if(head->val < x) {
                p->next = head;
                p = head;
            } else {
                q->next = head;
                q = head;
            }
            head = head->next;
        }
        p->next = gtHead->next;
        q->next = NULL;
        return ltHead->next;
    }
};
