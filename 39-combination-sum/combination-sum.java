class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
       findans(0, target, candidates, ans, new ArrayList<>());
       return ans;
    }
    private void findans(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> ds)
    {
        if(i==candidates.length)
        {
            if(target==0)
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(candidates[i]<=target)
        {
            ds.add(candidates[i]);
            findans(i, target-candidates[i], candidates, ans, ds);
            ds.remove(ds.size()-1);
        }
        findans(i+1, target, candidates, ans, ds);
    }
}