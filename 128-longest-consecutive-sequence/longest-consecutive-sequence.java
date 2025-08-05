class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest=1, lastsmaller=Integer.MIN_VALUE, currentcount=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1==lastsmaller)
            {
                currentcount++;
                lastsmaller=nums[i];
            }
            else if(nums[i]!=lastsmaller)
            {
                currentcount=1;
                lastsmaller=nums[i];
            }
            longest=Math.max(longest, currentcount);
        }
        return longest;
    }
}