class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for(int index=n-1;index>=0;index--)
        {
            for(int prev=index-1; prev>=-1;prev--)
            {
                 int len=dp[index+1][prev+1];

                 if(prev==-1 || nums[index]>nums[prev])
                 len=Math.max(len, 1+dp[index+1][index+1]);

                 dp[index][prev+1]=len;
            }
        }

        return dp[0][0];
    }
}