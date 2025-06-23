class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        findans(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    private void findans(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> res)
    {
        if(target==0)
         {
             ans.add(new ArrayList<>(res));
            return;
         }
        for(int i=index; i<nums.length;i++)
        {
            if(i!=index && nums[i]==nums[i-1]) continue;
            if(nums[i]> target) break;

            res.add(nums[i]);
            findans(i+1, nums, target-nums[i], ans, res);
            res.remove(res.size()-1);
        }
    }
}