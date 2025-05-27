class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n=nums.length;
        int p=pattern.length;
        StringBuilder pstring=new StringBuilder();
        StringBuilder nstring=new StringBuilder();

        for(int i=0;i<p;i++)
        {
            if(pattern[i]==1)
            pstring.append('a');
            else if(pattern[i]==0)
            pstring.append('s');
            else
            pstring.append('d');
        }
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<nums[i+1])
            nstring.append('a');
            else if(nums[i]==nums[i+1])
            nstring.append('s');
            else
            nstring.append('d');
        }
        String combined = pstring.toString() + "#" + nstring.toString();
        int[] lps = kmp(combined);
        int count = 0;

        for(int i=p+1;i<lps.length;i++)
        {
            if(lps[i]==p)count++;
        }
        return count;
    }
    private int[] kmp(String s)
    {
        int[] lps=new int[s.length()];
        for(int i=1;i<s.length();i++)
        {
            int prev_index=lps[i-1];
            while(s.charAt(i)!=s.charAt(prev_index) && prev_index>0)
            prev_index=lps[prev_index-1];

            lps[i]=prev_index+(s.charAt(prev_index)==s.charAt(i)?1:0);
        }
        return lps;
    }
}