class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1 || s==null)
        return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            int len1=maxlength(s,i,i);
            int len2=maxlength(s,i,i+1);
            int max=Math.max(len1,len2);
            if(max>end-start)
            {
                start=i-(max-1)/2;
                end=i+(max)/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int maxlength(String s, int i, int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return j-i-1;
    }
}