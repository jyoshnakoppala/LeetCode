class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
     int[][] dp = new int[n][n];
     for(int[] row: dp) java.util.Arrays.fill(row, -1); 
     if(s.length()<2) return s;
     String max = s.substring(0,1);
     for(int i=0;i<n;i++)
     {
        for(int j=i+max.length();j<n;j++)
        {
            if(ispal(s,i,j,dp)==1)
            {
                if(j-i+1>max.length())
                max=s.substring(i,j+1);
            }
        }
     }
     return max;
    }
    private int ispal(String s, int i, int j, int[][] dp)
    {
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
        return dp[i][j]=ispal(s, i+1, j-1, dp);
        return 0;
    }
}