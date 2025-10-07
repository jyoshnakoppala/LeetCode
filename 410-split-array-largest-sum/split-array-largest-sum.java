class Solution {
    public int splitArray(int[] nums, int k) {
        int low=getmax(nums);
        int high=sum(nums);
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(noofstudents(nums, mid)<=k)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    private int noofstudents(int[] nums, int capacity)
    {
        int split=1;
        int sum=0;
        for(int num:nums)
        {
            if(sum+num>capacity)
            {
                sum=num;
                split++;
            }
            else
            {
                sum+=num;
            }
        }
        return split;
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