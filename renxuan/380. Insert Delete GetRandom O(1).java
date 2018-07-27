class RandomizedSet {
    Random rand;
    List<Integer> list;
    Map<Integer, Integer> pos;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand = new Random();
        list = new ArrayList<>();
        pos = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(pos.containsKey(val)) return false;
        pos.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!pos.containsKey(val)) return false;
        int index = pos.get(val);
        if(index != list.size() - 1) {
            pos.put(list.get(list.size() - 1), index);
            list.set(index, list.get(list.size() - 1));
        }
        pos.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        int randNum = rand.nextInt(size);
        return list.get(randNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 