#include <iostream>
#include <vector>
using namespace std;

vector<int> aux;

void merge(int lo, int mi, int hi, vector<int> &nums) {
    int k = lo;
    for(int i = lo, j = mi; k <= hi; k++) {
        if(j > hi || i < mi && nums[i] < nums[j])
            aux[k] = nums[i++];
        else
            aux[k] = nums[j++];
    }
    for(int i = lo; i <= hi; i++)
        nums[i] = aux[i];
}

void mergeSort(int lo, int hi, vector<int> &nums) {
    if(lo >= hi) return;
    int mi = lo + (hi - lo) / 2;
    mergeSort(lo, mi, nums);
    mergeSort(mi + 1, hi, nums);
    merge(lo, mi + 1, hi, nums);
}

void mergeSort(vector<int> &nums) {
    aux = vector<int>(nums.size());
    mergeSort(0, nums.size() - 1, nums);
}

int main() {
    int v;
    vector<int> nums;
    while(cin >> v) nums.push_back(v);
    mergeSort(nums);
    for(int v: nums)
        cout << v << " ";
    cout << endl;
    return 0;
}
