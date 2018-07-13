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
    bool isPalindrome(ListNode* head) {
        if(!head || !head->next) return true;
        auto slow = head, fast = head;
        while(fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        if(fast) {
            slow = slow->next;
        }
        auto p = reverseList(slow);
        while(p) {
            if(p->val != head->val) return false;
            p = p->next;
            head = head->next;
        }
        return true;
    }
    ListNode *reverseList(ListNode *head) {
        if(!head || !head->next) return head;
        auto p = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return p;
    }
};
