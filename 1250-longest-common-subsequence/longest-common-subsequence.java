class Solution {
    int flag=0;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lcs(n-1, m-1, text1, text2, dp);
    }
    private int lcs(int n, int m, String text1, String text2, int[][] dp)
    {
        if(n<0 || m<0) return 0;

        if(dp[n][m]!=-1) return dp[n][m];
        if(text1.charAt(n)==text2.charAt(m)) 
        return dp[n][m]=1+lcs(n-1, m-1, text1, text2, dp);

        return dp[n][m]=Math.max(lcs(n-1, m, text1, text2, dp), lcs(n, m-1, text1, text2, dp));
    }
}