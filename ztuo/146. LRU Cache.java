class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    //add node after head node.
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;     
        head.post.pre = node;
        head.post = node;
    }
    
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.post;
        pre.post = next;
        next.pre = pre;
    }
    
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    
    private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int count; // current number of elements
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        head.pre = null;
        
        tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; 
        }
        this.moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null) { // if such node is not in the hashtable
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if(count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
              }
         }else{
                node.value = value;
                this.moveToHead(node);          
          }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */