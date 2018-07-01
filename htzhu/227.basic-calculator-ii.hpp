class Solution {
    stack<int> nums;
    stack<char> ops;
public:
    int calculate(string s) {
        string acc;
        for(auto c: s) {
            if(isdigit(c)) acc.push_back(c);
            else if(c != ' ') {
                if(!acc.empty()) {
                    nums.push(stoi(acc));
                    acc.clear();
                }
                while(!ops.empty() && prec(c) <= prec(ops.top())) {
                    eval();
                }
                ops.push(c);
            }
        }
        if(!acc.empty()) {
            nums.push(stoi(acc));
            acc.clear();
        }
        while(!ops.empty()) {
            eval();
        }
        return nums.top();
    }
    int prec(char c) {
        switch(c) {
        case '+':
        case '-':
            return 0;
        case '*':
        case '/':
            return 1;
        default:
            return -1;
        }
    }
    void eval() {
        char op = ops.top(); ops.pop();
        int b = nums.top(); nums.pop();
        int a = nums.top(); nums.pop();
        nums.push(cal(a, b, op));
    }
    int cal(int a, int b, char op) {
        switch(op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            return a / b;
        default:
            return -1;
        }
    }
};
