class MaxStack {
    stack<int> stk, maxStk;
public:
    /** initialize your data structure here. */
    MaxStack() {
        
    }
    
    void push(int x) {
        stk.push(x);
        maxStk.push(maxStk.empty() ? x : max(x, maxStk.top()));
    }
    
    int pop() {
        int res = top();
        stk.pop();
        maxStk.pop();
        return res;
    }
    
    int top() {
        return stk.top();
    }
    
    int peekMax() {
        return maxStk.top();
    }
    
    int popMax() {
        int val = maxStk.top();
        stack<int> buf;
        while(!stk.empty() && stk.top() != val) {
            buf.push(stk.top());
            stk.pop();
            maxStk.pop();
        }
        stk.pop();
        maxStk.pop();
        while(!buf.empty()) {
            push(buf.top());
            buf.pop();
        }
        return val;
    }
};

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
