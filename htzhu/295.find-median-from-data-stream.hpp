class MedianFinder {
    priority_queue<int, vector<int>> lo;
    priority_queue<int, vector<int>, greater<int>> hi;
public:
    /** initialize your data structure here. */
    MedianFinder() {
    }
    
    void addNum(int num) {
        lo.push(num);
        hi.push(lo.top());
        lo.pop();
        if(hi.size() > lo.size()) {
            lo.push(hi.top());
            hi.pop();
        }
    }
    
    double findMedian() {
        if(lo.size() == hi.size()) {
            return (lo.top() + hi.top()) / 2.0;
        } else {
            return lo.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
