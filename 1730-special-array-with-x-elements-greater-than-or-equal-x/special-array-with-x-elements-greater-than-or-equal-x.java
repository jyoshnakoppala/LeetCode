class Solution {
    private int upperbound(int[] nums, int x)
    {
        int ans=nums.length;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int n=nums.length;
        int low=0;
        int high=nums.length;
        while(low<=high)
        {
            int mid=(low+high)/2;

            count=n-upperbound(nums, mid);
            if(count==mid)
            return count;

            else if(count>mid)
            low=mid+1;
            else
            high=mid-1;
        }
        return -1;
    }
}