class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int j=0;j<amount+1;j++)
        {
        if(j%coins[0]==0)
        dp[0][j] = j/coins[0];
        else dp[0][j] = Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<amount+1;j++)
            {

                int nottake=dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j) 
                 {
                    int res = dp[i][j-coins[i]];
                    if (res != Integer.MAX_VALUE)  
                    take = 1 + res;
                 }
                 dp[i][j]=Math.min(take, nottake);
            }
        }
        int ans=dp[n-1][amount];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}