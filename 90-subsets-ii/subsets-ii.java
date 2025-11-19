class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        findans(0, ans, nums, new ArrayList<>());
        return ans;
    }
    private void findans(int index, List<List<Integer>> ans, int nums[], List<Integer> list)
    {
        ans.add(new ArrayList<>(list));
        for(int i=index; i<nums.length;i++)
        {
            if(i!=index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            findans(i+1, ans, nums, list);
            list.remove(list.size()-1);
        }
    }
}