import java.util.*;
public class MyMergeSort {
    public static void main(String[] args) {
        int var1 = "9".compareTo("933");
        System.out.println("8".compareTo("1"));
        System.out.println("9".compareTo("199"));
        System.out.println("990".compareTo("99"));
        int[] nums = new int[] {3, 2, 5, 6, 4, 4, 8, 9, 1, 3, 7};
        //int[] nums = new int[] {3, 2, 5};

        MyMergeSort s = new MyMergeSort();
        System.out.println(Arrays.toString(nums));

        s.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if(mid == start) {
            if(nums[start] > nums[end]) {
                swap(nums, start, end);                
            }
            return;
        }
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int[] num1 = Arrays.copyOfRange(nums, start, mid + 1);
        int[] num2 = Arrays.copyOfRange(nums, mid + 1, end + 1);
        
        int i = 0, j = 0, k = start;

        while(i < num1.length && j < num2.length) {
            if(num1[i] > num2[j]) {
                nums[k] = num2[j];
                j++;
            } else {
                nums[k] = num1[i];
                i++;
            }
            k++;
        }

        while(i < num1.length) {
            nums[k++] = num1[i++];
        }

        while(j < num2.length) {
            nums[k++] = num2[j++];
        }

    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}