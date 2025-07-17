class Solution {
    private int findans(int i, int[] coins, int target, int[][] dp)
    {
        if(i==0)
        {
        if(target%coins[0]==0)
        return target/coins[0];
        else
        return Integer.MAX_VALUE;
        }

        if(dp[i][target]!=-1) return dp[i][target];

        int nottake=findans(i-1, coins, target, dp);
        int take=Integer.MAX_VALUE;
        if(coins[i]<=target) 
        {
        int res = findans(i, coins, target - coins[i], dp);
            if (res != Integer.MAX_VALUE)  
                take = 1 + res;
        }

        return dp[i][target]=Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        int ans= findans(n-1, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}