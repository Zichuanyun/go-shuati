class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        vector<int> res;
        unordered_map<int, int> temp;
        
        for(int i=0; i<nums.size(); i++){
            int dif = target - nums[i];
            if(temp.find(dif) != temp.end()){
                res.push_back(temp[dif]);
                res.push_back(i);
                return res;
            }
            else temp[nums[i]] = i;
        }
    }
};
