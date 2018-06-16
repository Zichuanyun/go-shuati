/*
[2,5,2,1,2], target = 5,
[
  [1,2,2],
  [5]
]

[1,2,2,2,5],5
不能重复用，同样用dfs
*/


class Solution{
    public List<List<Integer>> combinationSumII(int[] array,int target){
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        Arrays.sort(array);
        dfs(array,target,path,res,0);
        return res;
    }
    
    public void dfs(int[] array,int target,List<Integer> path,List<List<Integer>> res,int start){
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i< array.length; i++){
            if(i>0 && array[i]==array[i-1]){
                continue;
            }
            if(targer - array[i] >=0){
                path.add(array[i]);
                dfs(array,target- array[i],path,res,i+1);
                path.remove(array[i]);
            }
        }
    }
}
