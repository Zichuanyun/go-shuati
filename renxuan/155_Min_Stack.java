class MinStack {
    int min;
    Stack<Integer> s;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }
    
    public void push(int x) {
        if(min >= x) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if(s.pop() == min) min = s.pop();
    }
    
    public int top() {        
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
