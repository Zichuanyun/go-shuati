import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    private int[] getTwoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{map.get(target - array[i]), i};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}
