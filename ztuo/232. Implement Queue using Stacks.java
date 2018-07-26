class MyQueue {

    Stack<Integer> queue;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<Integer>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!queue.empty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }
    


    public int pop() {
        return queue.pop();
    }


    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */