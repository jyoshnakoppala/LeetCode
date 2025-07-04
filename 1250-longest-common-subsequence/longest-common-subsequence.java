class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1)) 
                cur[j]=1+prev[j-1];
                 
                else
                cur[j]=Math.max(prev[j], cur[j-1]);
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[m];
    }
}