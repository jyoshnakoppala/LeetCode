class Solution {
    private int Lis(int index, int prev, int[] nums, int n, int[][] dp)
    {
        if(index==n) return 0;
        if(dp[index][prev+1]!=-1)
        return dp[index][prev+1];

        int len=0+Lis(index+1, prev, nums, n, dp);

        if(prev==-1 || nums[index]>nums[prev])
        len=Math.max(len, 1+Lis(index+1, index, nums, n, dp));

        return dp[index][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return Lis(0, -1, nums, n, dp);
    }
}