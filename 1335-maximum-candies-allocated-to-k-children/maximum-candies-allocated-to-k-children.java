class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        int high=maximum(candies);
        int ans=0;
        while(low<=high)
        {
            int mid = low + (high - low) / 2;
            if(findcandies(mid, candies)>=k)
            {
                low=mid+1;
                ans=mid;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    private long findcandies(int mid, int[] candies)
    {
        long sum = 0L; 
        for(int candy:candies)
        {
            sum+=candy/mid;
        }
        return sum;
    }
    private int maximum(int[] candies)
    {
        int maxi=0;
        for(int candy:candies)
        {
            if(candy>maxi)
            maxi=candy;
        }
        return maxi;
    }
}