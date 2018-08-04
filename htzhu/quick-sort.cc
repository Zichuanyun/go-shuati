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

void quickSort(int lo, int hi, vector<int> &nums) {
    if(lo >= hi) return;
    int p = partition(lo, hi, nums);
    quickSort(lo, p - 1, nums);
    quickSort(p + 1, hi, nums);
}

void quickSort(vector<int> &nums) {
    quickSort(0, nums.size() - 1, nums);
}

int main() {
    int v;
    vector<int> nums;
    while(cin >> v) nums.push_back(v);
    quickSort(nums);
    for(int v: nums)
        cout << v << " ";
    cout << endl;
    return 0;
}
