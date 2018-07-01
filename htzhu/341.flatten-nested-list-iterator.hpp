/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class NestedIterator {
    stack<vector<NestedInteger>::iterator> stk, estk;
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        if(!nestedList.empty()) {
            stk.push(nestedList.begin());
            estk.push(nestedList.end());
        }
    }

    int next() {
        return (stk.top()++)->getInteger();
    }

    bool hasNext() {
        while(!stk.empty()) {
            if(stk.top() == estk.top()) {
                stk.pop();
                estk.pop();
            } else {
                if(stk.top()->isInteger()) return true;
                auto it = stk.top()++;
                // outer finished
                stk.push(it->getList().begin());
                estk.push(it->getList().end());
            }
        }
        return !stk.empty();
    }
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */
