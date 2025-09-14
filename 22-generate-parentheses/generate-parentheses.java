class Solution {
    private void generateResult(List<String> result, int n, int open, int close, String s)
    {
        if(s.length()==2*n)
        {
            result.add(s);
            return;
        }
        if(open<n)
        {
            generateResult(result, n, open+1, close, s+"(");
        }
        if(close<open)
        {
            generateResult(result, n, open, close+1, s+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generateResult(result, n, 0, 0, "");
        return result;
    }
}