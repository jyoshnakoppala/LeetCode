class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()==0) return true;
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                return validpalindrome(i+1, j, s)||validpalindrome(i, j-1, s);
            }
        }
        return true;
    }
    private boolean validpalindrome(int i, int j, String s)
    {
        while(i<j)
        {
        if(s.charAt(i)!=s.charAt(j)) return false;
        i++;
        j--;
        }
        return true;
    }
}