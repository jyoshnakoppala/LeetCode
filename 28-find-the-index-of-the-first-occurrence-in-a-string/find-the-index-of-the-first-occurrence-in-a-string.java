class Solution {
    public int strStr(String haystack, String needle) {
      if(needle.length() == 0) return 0;  
      StringBuilder nstring=new StringBuilder(needle);
      StringBuilder hstring=new StringBuilder(haystack);

      String Combined = nstring + "#" + hstring;
      int[] lps=kmp(Combined);
      int index=0;
      for(int i=needle.length()+1;i<lps.length;i++)
      {
        if(lps[i]==needle.length())
        return i-2*needle.length();
      }
      return -1;
    }
    public int[] kmp(String s)
    {
        int[] lps =new int[s.length()];
        for(int i=1;i<s.length();i++)
        {
            int j=lps[i-1];
            while(s.charAt(i)!=s.charAt(j) && j>0)
            {
                j=lps[j-1];
            }
            lps[i]=j+(s.charAt(i)==s.charAt(j)?1:0);
        }
        return lps;
    }
}