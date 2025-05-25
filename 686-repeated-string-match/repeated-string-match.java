class Solution {
    public int repeatedStringMatch(String a, String b) {
    int count=1;
    StringBuilder temp=new StringBuilder(a);
    while(temp.length()<b.length())
    {
    temp.append(a);
    count++;
    }
    if(robinkarp(temp.toString(),b)) return count;
    temp.append(a);
    if(robinkarp(temp.toString(),b)) return count+1;
    return -1;
    }
    private boolean robinkarp(String text, String pattern)
    {
        int base=256;
        long mod = 1_000_000_007L;
        int n=text.length(), m=pattern.length();
        if(m>n)return false;

        long patternHash=0, textHash=0;
        long factor =1;

        for(int i=m-1;i>=0;i--)
        {
            patternHash=(patternHash+(pattern.charAt(i)-'a')*factor%mod)%mod;
            textHash=(textHash+(text.charAt(i)-'a')*factor%mod)%mod;
            factor=(factor*base)%mod;
        }
        long highestpower=1;
        for(int i=1;i<m;i++){
            highestpower=(highestpower*base)%mod;
        }

        for(int i=0;i<=n-m;i++)
        {
            if(patternHash==textHash)
            {
                if(text.substring(i,i+m).equals(pattern)) 
                return true;
            }
            if(i<n-m){
                textHash=(textHash-((text.charAt(i)-'a')*highestpower%mod)+mod)%mod;
                textHash=(textHash*base+(text.charAt(i+m)-'a'))%mod;
            }
        }
        return false;
    }
}