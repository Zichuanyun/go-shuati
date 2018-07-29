class LRUCache {
    unordered_map<int, int> cache;
    unordered_map<int, list<int>::iterator> key2it;
    list<int> pool;
    int capacity;
public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    int get(int key) {
        touch(key);
        return cache.count(key) ? cache[key] : -1;
    }
    
    void put(int key, int value) {
        if(cache.count(key)) {
            touch(key);
            cache[key] = value;
            return;
        }
        if(pool.size() == capacity) {
            int lruKey = pool.back();
            cache.erase(lruKey);
            key2it.erase(lruKey);
            pool.pop_back();
        }
        pool.push_front(key);
        key2it[key] = pool.begin();
        cache[key] = value;
    }
    void touch(int key) {
        if(!cache.count(key)) return;
        auto it = key2it[key];
        if(it != pool.begin()) {
            pool.erase(it);
            pool.push_front(key);
            key2it[key] = pool.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
