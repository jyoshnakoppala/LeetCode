class Solution {
    public int maxFrequency(int[] nums, int k) {
       long total=0;
       int l=0; int maxfreq=0;
       Arrays.sort(nums);

       for(int r=0;r<nums.length;r++)
       {
        total+=nums[r];
        while(l+1<=r && (long)nums[r]*(r-l+1)>total+k)
        {
            total-=nums[l];
            l++;
        }
        maxfreq=Math.max(maxfreq, r-l+1);
       }
       return maxfreq;
    }
}