class Solution {
    public String longestPalindrome(String s) {
     int n = s.length();
     String max = s.substring(0,1);
     for(int i=0;i<n;i++)
     {
        String odd = ispal(s, i, i);
        if(odd.length()>max.length())
        max = odd;
        String even = ispal(s, i, i+1);
        if(even.length()>max.length())
        max = even;
     }
     return max;
    }
    private String ispal(String s, int i , int j){
        int n=s.length();
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}