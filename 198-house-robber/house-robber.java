class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        dp=new Integer[101];
        return findans(nums, nums.length-1);
    }
    private int findans(int[] nums, int idx)
    {
        if(idx<0) return 0;

        if(dp[idx]!=null) return dp[idx];

        return dp[idx] = Math.max(nums[idx]+ findans(nums, idx-2), findans(nums, idx-1));
    }
}