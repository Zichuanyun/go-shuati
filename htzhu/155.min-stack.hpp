class MinStack {
    stack<int> stk, minStk;
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        stk.push(x);
        minStk.push(minStk.empty() ? x : min(minStk.top(), x));
    }
    
    void pop() {
        stk.pop();
        minStk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minStk.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
