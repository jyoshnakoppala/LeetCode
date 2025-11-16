class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       findans(1, n, k, new ArrayList<>());
       return res; 
    }
    private void findans(int ind, int n, int k, List<Integer> ds)
    {
        if(ds.size()==k)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i <= n - (k - ds.size())+1; i++)
        {
            ds.add(i);
            findans(i+1, n, k, ds);
            ds.remove(ds.size()-1);
        }
    }
}