class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return findans(0, s, dp, wordDict);
    }
    private boolean findans(int i, String s, int[] dp, List<String> wordDict)
    {
        if(i>=s.length()) return true;
        if(dp[i]!=-1) return dp[i]==1;
        for(String word:wordDict)
        {
            int curlen=word.length();
            if(i+curlen>s.length()) continue;
            if(s.substring(i,i+curlen).equals(word) && findans(i+curlen, s, dp, wordDict)){
                dp[i]=1;
                return true;
            }
        }
        dp[i]=0;
        return false;
    }
}