class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Node head, tail;
    Map<Integer, Node> map;
    int capacity, size;

    public LRUCache(int capacity) {
        head = new Node(0, 0); tail = new Node(0, 0);
        head.next = tail; tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
        map.remove(node.key);
    }

    private void add(Node node) {
    	node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    	++size;
    	map.put(node.key, node);
    	if(size > capacity) remove(tail.prev);
    }
    
    private void moveToHead(Node node) {
        remove(node);
        add(node);
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)) {
            map.get(key).value = value;
            moveToHead(map.get(key));
        }
        else add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 