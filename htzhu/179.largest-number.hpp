class Solution {
public:
    string largestNumber(vector<int>& nums) {
        if(nums.empty()) return "";
        auto cmp = [](const string &s, const string &t) {
                       return s + t > t + s;
                   };
        vector<string> strs;
        for(int x: nums)
            strs.push_back(to_string(x));
        sort(strs.begin(), strs.end(), cmp);
        if(strs[0] == "0") return "0";
        string ans;
        for(auto &s: strs)
            ans += s;
        return ans;
    }
};
