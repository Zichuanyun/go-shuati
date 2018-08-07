public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        for (--m, --n; m >= 0 && n >= 0; --end) {
            if (nums1[m] > nums2[n]) {
                nums1[end] = nums1[m];
                --m;
            } else {
                nums1[end] = nums2[n];
                --n;
            }
        }
        while (n >= 0) {
            nums1[end--] = nums2[n--];
        }
    }
}