class ZigzagIterator {
    vector<int>::iterator s1, s2, e1, e2;
    int cur = 0;
public:
    ZigzagIterator(vector<int>& v1, vector<int>& v2) {
        s1 = v1.begin();
        e1 = v1.end();
        s2 = v2.begin();
        e2 = v2.end();
    }

    int next() {
        if(s2 == e2 || s1 != e1 && cur == 0) {
            int val = *(s1++);
            if(s2 != e2) cur = 1;
            return val;
        } else {
            int val = *(s2++);
            if(s1 != e1) cur = 0;
            return val;
        }
    }

    bool hasNext() {
        return !(s1 == e1 && s2 == e2);
    }
};

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i(v1, v2);
 * while (i.hasNext()) cout << i.next();
 */
