class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        if(n<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<n-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            continue;

            int target=-nums[i];
            int left=i+1;
            int right=n-1;

            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    int currentLeft=nums[left];
                    while(left<right && nums[left]==currentLeft)
                    left++;

                    int currentRight=nums[right];
                    while(left<right && nums[right]==currentRight)
                    right--;
                }
                else if(sum< target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }

        }
        return result;
    }
}