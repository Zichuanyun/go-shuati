public class Solution {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
		int count = 0;
		while(a > 0) {
			count += a % 2;
			a = a / 2;
		}
        return count;
    }
}
