class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        findans(nums, 0, list);
        return res;
    }
    private void findans(int[] nums, int idx, List<Integer> list)
    {
        if(idx==nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        findans(nums, idx+1, list);

        list.remove(list.size()-1);

        findans(nums, idx+1, list);
    }
}