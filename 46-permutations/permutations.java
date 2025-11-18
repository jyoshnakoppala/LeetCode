class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
       findans(nums, 0, ans);
       return ans; 
    }
    private void findans(int[] nums, int idx, List<List<Integer>> ans)
    {
        if(idx==nums.length)
        {
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(idx, i, nums);
            findans(nums, idx+1, ans);
            swap(idx, i, nums);
        }
    }
    private void swap(int i, int j, int[] nums)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}