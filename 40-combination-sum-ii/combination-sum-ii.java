class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findans(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    private void findans(int[] candidates, int target, int ind, List<Integer> ds)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<candidates.length;i++)
        {
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            ds.add(candidates[i]);
            findans(candidates, target-candidates[i], i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}