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
    ListNode* sortList(ListNode* head) {
        if(!head) return NULL;
        return mergeSort(head, NULL);
    }
    ListNode *mergeSort(ListNode *lo, ListNode *hi) {
        if(lo == hi || lo->next == hi) {
            lo->next = NULL;
            return lo;
        }
        auto slow = lo, fast = lo;
        while(fast != hi && fast->next != hi) {
            slow = slow->next;
            fast = fast->next->next;
        }
        auto left = mergeSort(lo, slow), right = mergeSort(slow, hi);
        return merge(left, right);
    }
    ListNode *merge(ListNode *left, ListNode *right) {
        ListNode *dummy = new ListNode(0);
        auto x = dummy;
        for(auto p = left, q = right; p || q; x = x->next) {
            if(!p || q && p->val > q->val) {
                x->next = q;
                q = q->next;
            } else {
                x->next = p;
                p = p->next;
            }
        }
        x->next = NULL;
        return dummy->next;
    }
};
