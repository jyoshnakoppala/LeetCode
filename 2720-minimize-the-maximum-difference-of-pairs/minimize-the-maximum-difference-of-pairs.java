class Solution {
    public boolean sortedorder(int[] nums, int m, int p){
        int pairs=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]-nums[i]<=m)
            {
                pairs++;
                i++;
            }
        }
        return pairs>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int l=0,h=nums[n-1]-nums[0];
        int ans=0;
        while(l<=h)
        {
            int m=(l+h)/2;
            if(sortedorder(nums, m, p))
            {
                ans=m;
                h=m-1;
            }
            else 
            {
                l=m+1;
            }
        }
        return ans;
    }
}