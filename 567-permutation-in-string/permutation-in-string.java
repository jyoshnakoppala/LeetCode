class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        return false;

        int[] freq=new int[26];

        for(int i=0;i<26;i++)
        freq[i]=-1;

        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int r=0, l=0, needed=s1.length();
        while(r<s2.length())
        {
            if(freq[s2.charAt(r)-'a']>=0)
            {
            needed--;
            }
            freq[s2.charAt(r)-'a']--;
            if(needed==0) return true;
            r++;
            if(r-l==s1.length())
            {
                if(freq[s2.charAt(l)-'a']>=-1)
                needed++;
                freq[s2.charAt(l)-'a']++;
                l++;
            }
        }
        return false;
    }
}