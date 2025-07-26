class Solution {
    private int lowerbound(int[] nums, int x)
    {
        int ans=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==x)
            {
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<x)
            low=mid+1;
            else
            high=mid-1;
        }
        return ans;
    }
    private int upperbound(int[] nums, int x)
    {
        int ans=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==x)
            {
                ans=mid;
                low=mid+1;
            }
            else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=lowerbound(nums, target);
        ans[1]=upperbound(nums, target);

        return ans;
    }
}