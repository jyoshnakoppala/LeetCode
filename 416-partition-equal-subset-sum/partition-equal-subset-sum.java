class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0;
        int n=nums.length;

        for(int num:nums)
        totalsum+=num;

        if(totalsum%2!=0)
        return false;

        int target=totalsum/2;
        boolean[][] dp=new boolean[n][target+1];
        
        for(int i=0;i<n;i++)
        {
        Arrays.fill(dp[i],false);
        dp[i][0]=true;
        }
        if (nums[0] <= target)
        dp[0][nums[0]]=true;
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean nottake=dp[i-1][j];
                boolean take =false;
                if(j>=nums[i])
                take=dp[i-1][j-nums[i]];
                dp[i][j] = take || nottake;
            }
        }
        return dp[n-1][target];
    }
}