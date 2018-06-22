/* [2,3,5], target = 8,
1 [2]6 x
2 [2 2]4 x [2,2,2]2 x [2,2,2,2]0 √ 
3          [2,2,3]1 x [2,2,2,3]-1 x
  [2,3]-3 x [2,3,3]0 √
4 [2 5]1 x [2,2,5]-1 x
5 [3,3]2 x [3,3,3]-1 x
6 [3,5]0 √  [3,3,5] -3 x
7 [5,5] -2 x
*/
class Solution {
     public List<List<Integer>> combinationSum(int[] candidates,int target){
        Arrays.sort(candidates);
        if(candidates.length == 0 || candidates == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,0,new ArrayList<Integer>(),res);
        return res; 
    }
    
    private void dfs(int[] candidates, int sum,int index,List<Integer> path, List<List<Integer>> res){

        if(sum == 0){
          res.add(new ArrayList<>(path));  //copy
          return;
        }
        
        //child
        for(int i = index; i<candidates.length; i++){
            if(sum - candidates[i] >=0 ){
                path.add(candidates[i]);
                dfs(candidates,sum-candidates[i],i,path,res);
                path.remove(path.size()-1);   //remove index
            }
        }
    }
}
