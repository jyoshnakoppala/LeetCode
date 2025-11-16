class Solution {
    int sum=0;
    public int subsetXORSum(int[] nums) {
        findans(nums, 0, 0);
        return sum;
    }
    private void findans(int[] nums, int idx, int cur)
    {
        if(idx==nums.length)
        {
            sum+=cur;
            return;
        }

        findans(nums, idx+1, cur^nums[idx]);

        findans(nums, idx+1, cur);
    }
}