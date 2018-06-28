class MaxStack {
    Deque<Integer> main_stack = new ArrayDeque<>();
    Deque<Integer> max_stack = new ArrayDeque<>();
    Deque<Integer> buffer = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
        main_stack.offerLast(x);
        if (max_stack.size() == 0 || max_stack.peekLast() < x) {
            max_stack.offerLast(x);
        } else {
            max_stack.offerLast(max_stack.peekLast());
        }
    }
    
    public int pop() {
        max_stack.pollLast();
        return main_stack.pollLast();
    }
    
    public int top() {
        return main_stack.peekLast();
    }
    
    public int peekMax() {
        return max_stack.peekLast();
    }
    
    public int popMax() {
        int max = max_stack.peekLast();
        int x = main_stack.peekLast();
        int y = max_stack.peekLast();
        // while (main_stack.peekLast() != max_stack.peekLast()) {
        while (x != y) {
            buffer.offerLast(pop());
            x = main_stack.peekLast();
            y = max_stack.peekLast();
        }
        pop();
        while (buffer.size() > 0) {
            push(buffer.pollLast());
        }
        return max;
    }
}