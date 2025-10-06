class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=getmax(weights);
        int high=sum(weights);
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(getdays(weights, mid) <=days)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    private int getdays(int[] weights, int capacity)
    {
        int sum=0;
        int days=1;
        for(int weight:weights)
        {
            if(sum+weight>capacity)
            {
                sum=weight;
                days+=1;
            }
            else
            sum+=weight;
        }
        return days;
    }
    private int getmax(int[] weights)
    {
        int maxi=0;
        for(int weight: weights)
        {
            if(weight>maxi)
            maxi=weight;
        }
        return maxi;
    }
    private int sum(int[] weights)
    {
        int sum=0;
        for(int weight: weights)
        {
            sum+=weight;
        }
        return sum;
    }
}