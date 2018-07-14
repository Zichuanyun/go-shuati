/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1, r = (long)n + 1;
        while(l < r) {
            int m = (int)(l + (r - l)/2);
            if(isBadVersion(m)) {
                r = m;
            }
            else l = m + 1;
        }
        return (int)l;
    }
}
