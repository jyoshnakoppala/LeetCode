class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp, -1);
        return findans(0, s, dp)-1;
    }
  
    private int findans(int ind, String s, int[] dp)
    {
        if(ind==s.length()) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int mincost=Integer.MAX_VALUE;
        for(int i=ind;i<s.length();i++)
        {
            if(ispalindrome(ind, i, s))
            {
                mincost=Math.min(mincost, 1+findans(i+1, s, dp));
            }
        }
        return dp[ind] = mincost;
    }
      private boolean ispalindrome(int st, int e, String s)
    {
        while(st<e)
        {
            if(s.charAt(st++)!=s.charAt(e--))
            return false;
        }
        return true;
    }
}