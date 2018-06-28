class MaxStack {
    Stack<Integer> s;
    Stack<Integer> maxS;

    public MaxStack() {
        s = new Stack<>();
        maxS = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if(maxS.empty() || x >= maxS.peek())
            maxS.push(x);
    }

    public int pop() {
        if(s.peek() == maxS.peek())
            maxS.pop();
        return s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return maxS.peek();
    }

    public int popMax() {
        int max = maxS.pop();
        Stack<Integer> t = new Stack<>();
        while(s.peek() != max) {
            t.push(s.pop());
        }
        s.pop();
        while(!t.empty()) {
            s.push(t.pop());
        }
        return max;
    }
}
