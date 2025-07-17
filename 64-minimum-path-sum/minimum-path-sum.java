class Solution {
    public int findans(int i, int j, int[][] grid, int[][] dp)
    {
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=findans(i-1, j, grid, dp);
        int left=findans(i, j-1, grid, dp);

        int mini=Math.min(up, left);
        if(mini==Integer.MAX_VALUE)
        dp[i][j]=Integer.MAX_VALUE;
        else
        dp[i][j]=grid[i][j]+mini;

        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return findans(n-1,m-1,grid, dp);
    }
}