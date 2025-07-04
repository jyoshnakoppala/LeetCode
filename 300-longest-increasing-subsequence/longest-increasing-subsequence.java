class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;
        int lastindex=0;
        for(int i=0;i<n;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i] && dp[i]<1+dp[j])
                {
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
             if(dp[i]>maxi)
                 {
                    maxi=dp[i];
                    lastindex=i;
                 }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(nums[lastindex]);
        while(hash[lastindex]!=lastindex)
        {
            lastindex=hash[lastindex];
            temp.add(nums[lastindex]);
        }
        Collections.reverse(temp);
        System.out.println("LIS sequence: " + temp);

         return maxi;
    }
}