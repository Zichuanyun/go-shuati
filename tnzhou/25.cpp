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
    int getLength(ListNode* head) {
        int n = 0;
        ListNode* cur = head;
        while (cur != NULL) {
            n++;
            cur = cur->next;
        }
        return n;
    }
    
    void print(ListNode* head) {
        ListNode* cur = head;
        while (cur != NULL) {
            cout << cur->val;
            cur = cur->next;
        }
        cout << endl;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        len = getLength(head);
        ListNode* cur_fa = NULL;
        ListNode* cur = head;
        for (int i = 0; i < len / k; i++) {
            for (int movetimes = k - 1; movetimes > 0; movetimes--) {
                ListNode* itr = cur;
                ListNode* itr_fa = cur_fa;
                cout << cur->val << endl;
                for (int j = 0; j < movetimes; j++) {
                    if (itr_fa != NULL)
                        itr_fa->next = itr->next;
                    else {
                        head = itr->next;
                    }
                    if (itr == cur) {
                        cur = itr->next;
                    }
                    itr->next = itr->next->next;
                    if (itr_fa != NULL) {
                        itr_fa->next->next = itr;
                        itr_fa = itr_fa->next;
                    } else {
                        head->next = itr;
                        itr_fa = head;
                    }
                    // print(head);
                }
            }
            for (int j = 0; j < k; j++) {
                cur_fa = cur;
                cur = cur->next;
            }
        }
        return head;
    }
private:
    int len;
};
