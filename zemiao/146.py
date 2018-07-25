class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.now = 0
        self.cap = capacity
        self.map = {}
        self.time = {}
        self.object = {}

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.map:
          return -1
        
        if key == self.object[self.now]:
          return self.map[key]
        
        self.now += 1
        self.object[self.now] = key
        del self.object[self.time[key]]
        self.time[key] = self.now
        return self.map[key]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        self.now += 1
        if key in self.map and self.time[key] != self.now:
          del self.object[self.time[key]]
        self.map[key] = value
        self.time[key] = self.now
        self.object[self.now] = key
        if len(self.map) > self.cap:
          earlist = min(self.object.keys())
          toDel = self.object[earlist]
          del self.map[toDel]
          del self.object[earlist]
          del self.time[toDel]
          

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)