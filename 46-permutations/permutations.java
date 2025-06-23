class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] unused=new boolean[nums.length];
        List<Integer> path=new ArrayList<>();
        findans(nums, ans, path, unused);
        return ans;
    }
    private void findans(int[] n, List<List<Integer>> ans, List<Integer> path, boolean[] unused)
    {
        if(path.size()==n.length)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<n.length;i++)
        {
            if(!unused[i])
            {
                unused[i]=true;
                path.add(n[i]);
                findans(n, ans, path, unused);
                path.remove(path.size()-1);
                unused[i]=false;
            }
        }
    }
}