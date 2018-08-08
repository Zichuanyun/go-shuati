public class ZigzagIterator {
    Iterator<Integer> it1, it2;
    int state;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        state = 0;
    }

    public int next() {
        ++state;
        if(state % 2 == 1 && it1.hasNext() || !it2.hasNext())
            return it1.next();
        else if(state % 2 == 0 && it2.hasNext() || !it1.hasNext())
            return it2.next();
        return 0;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
 