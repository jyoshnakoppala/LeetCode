class Solution {
    public int firstMissingPositive(int[] nums) {
    
        int n=nums.length;
        int containsone=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0 || nums[i]>n)
            nums[i]=1;
            else if(nums[i]==1)
            containsone=1;
        }

        if(containsone==0) return 1;
        for(int i=0;i<n;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0) nums[index]=-nums[index];
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) return i+1;
        }

        return n+1;
    }
}