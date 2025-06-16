class Solution {
    public int maximumDifference(int[] nums) {
        int max=-1;
        int min=nums[0];
        int maxdiff=-1;
        for(int i=1;i<nums.length;i++)
        {
           if(nums[i]>min)
           maxdiff=Math.max(maxdiff, nums[i]-min);
           else
           min=nums[i];

        }
    return maxdiff;
    }
}