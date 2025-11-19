class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        findans(0, s, new ArrayList<>());
        return res;
    }
    private void findans(int idx, String s, List<String> ds)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(ispalindrome(s, idx, i))
            {
                ds.add(s.substring(idx, i+1));
                findans(i+1, s, ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    private boolean ispalindrome(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }
}