public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; ++i) {
            if(isPrime(i)) ++count;
        }        
        return count;
    }
    
    private boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); ++i) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
