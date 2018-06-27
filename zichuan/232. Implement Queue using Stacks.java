class MyQueue {
    
    Stack<Integer> stack_1, stack_2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack_1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack_1.empty()) {
            stack_2.push(stack_1.pop());
        }
        
        int res = stack_2.pop();
        while(!stack_2.empty()) {
            stack_1.push(stack_2.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stack_1.empty()) {
            stack_2.push(stack_1.pop());
        }
        int res = stack_2.peek();
        while(!stack_2.empty()) {
            stack_1.push(stack_2.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack_1.empty();
    }
}
