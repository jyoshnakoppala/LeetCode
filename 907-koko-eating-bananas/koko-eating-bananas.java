class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1, high=maximum(piles);
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(caneat(piles, mid, h))
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    private boolean caneat(int[] piles, int mid, int h)
    {
        long hours=0;
        for(int pile:piles)
        {
            hours+=(pile + mid - 1L) / mid;
        }
        if(hours>h) return false;
        else
        return true;
    }
    private int maximum(int[] piles)
    {
        int max=Integer.MIN_VALUE;
        for(int pile:piles)
        {
            if(pile>max)
            max=pile;
        }
        return max;
    }
}