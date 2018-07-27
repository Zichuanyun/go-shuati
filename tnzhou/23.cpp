/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class CompareDist
{
public:
    bool operator()(pair<int,int> n1,pair<int,int> n2) {
        return n1.first>n2.first;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue <pair<int,int>, vector<pair<int, int>>, CompareDist> pq;
        for (int i = 0; i < lists.size(); i++) {
            if (lists[i] != NULL) {
                pq.push(make_pair(lists[i]->val, i));
                lists[i] = lists[i]->next;
            }
        }
        ListNode* resHead = new ListNode(0);
        ListNode* cur = resHead;
        while (!pq.empty()) {
            int val = pq.top().first;
            cur->next = new ListNode(val);
            cur = cur->next;
            int idx = pq.top().second;
            pq.pop();
            if (lists[idx] != NULL) {
                pq.push(make_pair(lists[idx]->val, idx));
                lists[idx] = lists[idx]->next;
            }
        }
        return resHead->next;
    }
};
