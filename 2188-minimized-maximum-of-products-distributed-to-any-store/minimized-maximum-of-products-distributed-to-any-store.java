class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1;
        int high=Arrays.stream(quantities).max().getAsInt();
        int res=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isPossible(mid, n, quantities))
            {
                res=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return res;
    }
    private boolean isPossible(int maxperstore, int n, int[] quantities)
    {
        int needperstore=0; 
        for(int q:quantities)
        {
            needperstore+=(q+maxperstore-1)/(maxperstore);
        }
       return needperstore<=n;
    }
}