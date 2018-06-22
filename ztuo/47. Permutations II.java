class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length==0) return null;
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int[] visited =new int[nums.length];
        Arrays.sort(nums);
        backtrack(result, temp, nums, visited);
        return result;
    }
    private void backtrack( List<List<Integer>> result, List<Integer> temp,int[] nums, int[] visited){
        if(temp.size()==nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1) continue;
            if(i!=0 && nums[i]==nums[i-1] && visited[i-1]==0) continue;
            visited[i]=1;
            temp.add(nums[i]);
            backtrack(result, temp, nums, visited);
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}