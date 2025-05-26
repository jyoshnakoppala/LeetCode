class Solution {
    public int strStr(String haystack, String needle) {
      int base = 256;
      long mod= 1_000_000_007L;
      int n=haystack.length();
      int m=needle.length();
      if(m>n)return -1;
      long haystackhash=0, needlehash=0;
      long factor=1;
      for(int i=m-1;i>=0;i--)
      {
        haystackhash=(haystackhash+haystack.charAt(i)*factor%mod)%mod;
        needlehash=(needlehash+needle.charAt(i)*factor%mod)%mod;
        factor=(factor*base)%mod;
      }  
      long highpower=1;
      for(int i=1;i<m;i++)
      highpower=(highpower*base)%mod;

      for(int i=0;i<=n-m;i++)
      {
        if(haystackhash==needlehash)
        {
            if (haystack.substring(i, i + m).equals(needle)) {
            return i;
            }
        }
        if(i<n-m)
        {
            haystackhash=(haystackhash-haystack.charAt(i)*highpower%mod+mod)%mod;
            haystackhash=(haystackhash*base+haystack.charAt(i+m))%mod;
        }
      }
    return -1;
    }
}