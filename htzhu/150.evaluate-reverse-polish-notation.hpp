class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> nums;
        for(auto &token: tokens) {
            if(isdigit(token.back())) {
                nums.push(stoi(token));
            } else {
                int b = nums.top();
                nums.pop();
                int a = nums.top();
                nums.pop();
                nums.push(calculate(a, b, token[0]));
            }
        }
        return nums.top();
    }
    int calculate(int a, int b, char op) {
        switch(op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            return a / b;
        }
        return INT_MAX;
    }
};
