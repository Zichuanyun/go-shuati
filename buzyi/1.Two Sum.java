/*
time:O(n)
space:o(n)
*/
class Solution{
    public int[] TwoSum(int[] a, int target){
        int[] result=new int[2];
        
        if(a==null || a.length <2){
            return result;
        }
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(target-a[i])){
                result[0]=map.get(target-a[i]);
                result[1]=i;
            }
            map.put(a[i],i);
        }
        return result;
    }
}
