#include <iostream>
#include <vector>
using namespace std;

int partition(int lo, int hi, vector<int> &nums) {
    int i = lo;
    for(int j = i; j < hi; j++)
        if(nums[j] <= nums[hi])
            swap(nums[i++], nums[j]);
    swap(nums[i], nums[hi]);
    return i;
}

int quickSelect(int lo, int hi, int k, vector<int> &nums) {
    if(lo >= hi) return lo;
    int p = partition(lo, hi, nums);
    int len = p - lo;
    if(len == k - 1) return p;
    else if(len < k - 1) return quickSelect(p + 1, hi, k - len - 1, nums);
    else return quickSelect(lo, p - 1, k, nums);
}

int quickSelect(int k, vector<int> &nums) {
    return quickSelect(0, nums.size() - 1, k, nums);
}

int main() {
    int k, v;
    vector<int> nums;
    cin >> k;
    while(cin >> v) nums.push_back(v);
    cout << nums[quickSelect(k, nums)] << endl;
    return 0;
}
