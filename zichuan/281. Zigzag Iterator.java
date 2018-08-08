public class ZigzagIterator {
    private int count;
    private int row = 0;
    private int pos = 0;
    private List<List<Integer>> v;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // this.v = v;
        v = new ArrayList<>();
        v.add(v1);
        v.add(v2);
        count = v.size();
        for (List<Integer> list : v) {
            if (list.size() == 0) {
                --count;
            }
        }
    }

    public int next() {
        if (!hasNext()) return -1;
        while (pos >= v.get(row).size()) {
            ++row;
            if (row == v.size()) {
                row = 0;
                ++pos;
            }
        }
        if (pos == v.get(row).size() - 1) --count;
        int res = v.get(row).get(pos);
        ++row;
        if (row == v.size()) {
            row = 0;
            ++pos;
        }
        return res;
    }

    public boolean hasNext() {
        return count > 0;
    }
}