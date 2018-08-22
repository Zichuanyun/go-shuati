class Vector2D {
    queue<vector<int>::iterator> starts, ends;
public:
    Vector2D(vector<vector<int>>& vec2d) {
        for(auto &vec: vec2d) {
            starts.push(vec.begin());
            ends.push(vec.end());
        }
    }

    int next() {
        return *(starts.front()++);
    }

    bool hasNext() {
        while(!starts.empty() && starts.front() == ends.front()) {
            starts.pop();
            ends.pop();
        }
        return !starts.empty();
    }
};

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i(vec2d);
 * while (i.hasNext()) cout << i.next();
 */
