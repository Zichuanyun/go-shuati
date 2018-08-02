class Solution {
    public bool canJump(int A[], int n) {
        int tail = n - 1, i, j;
        for (i = n - 2; i >= 0; i--){
            if(i + A[i] >= tail) {
                tail = i;
            }
        }
        return tail <= 0;
    }
}