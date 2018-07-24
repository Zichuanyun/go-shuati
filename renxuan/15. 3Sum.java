class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList(); 
        for (int first = 0; first < num.length-2; first++) {
            if (first == 0 || (first > 0 && num[first] != num[first-1])) {
                int second = first+1, third = num.length-1, sum = -num[first];
                while (second < third) {
                    if (num[second] + num[third] == sum) {
                        res.add(Arrays.asList(num[first], num[second], num[third]));
                        while (second < third && num[second] == num[second+1]) second++;
                        while (second < third && num[third] == num[third-1]) third--;
                        second++; third--;
                    } 
                    else if (num[second] + num[third] < sum) second++;
                    else third--;
               }
            }
        }
        return res;
    }
}
