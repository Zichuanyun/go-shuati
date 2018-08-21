class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, end = 0, remain = 0;
        do {
            if(remain + gas[end] >= cost[end]) {
                remain += gas[end] - cost[end];
                end = (end + 1) % gas.length;
            }
            else {
                start = (start - 1 + gas.length) % gas.length;
                remain += gas[start] - cost[start];
            }
            
        } while(start != end);
        return remain >= 0 ? start : -1;
    }
}
