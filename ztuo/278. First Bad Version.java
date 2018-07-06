/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1; int e = n;        
        while(s < e) {
            int mid = (e - s) / 2 + s;
            if(isBadVersion(mid)) {
                e = mid;
            } else{
                s = mid + 1;
            }           
        }
        return s;
    }
}