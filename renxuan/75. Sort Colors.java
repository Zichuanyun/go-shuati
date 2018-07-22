class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        int i = 0;
        while(i <= two) {
            if(nums[i] == 0)
                swap(nums, i++, zero++);
            else if(nums[i] == 2)
                swap(nums, i, two--);
            else i++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
