class Solution {
    private boolean findans(int i, int[] nums, int target, int[][] dp)
    {
        if(target==0) return true;
        if(i==0)
        return nums[0]==target;
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean nottake=findans(i-1, nums, target, dp);
        boolean take =false;
        if(target>=nums[i])
        take=findans(i-1, nums, target-nums[i], dp);
        dp[i][target] = (take || nottake) ? 1 : 0;
        return take || nottake;
    }
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        int n=nums.length;

        for(int num:nums)
        totalsum+=num;

        if(totalsum%2!=0)
        return false;

        int target=totalsum/2;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return findans(n-1, nums, target, dp);
    }
}