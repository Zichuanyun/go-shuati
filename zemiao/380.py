class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = []
        self.map = {}

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        if val in self.map:
          return False
        
        self.map[val] = len(self.m)
        self.m.append(val)
        return True

    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        :type val: int
        :rtype: bool
        """
        if val not in self.map:
          return False
        
        i = self.map[val]
        if i != len(self.m)-1:
          self.m[i], self.m[-1] = self.m[-1], self.m[i]
          self.map[self.m[i]] = i
        self.m.pop()
        del self.map[val]
        return True

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """
        r = random.randint(0,len(self.map)-1)
        return self.m[r]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()