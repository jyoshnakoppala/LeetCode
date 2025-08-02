class Solution {
    public int removeElement(int[] nums, int val) {
        int place=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=val)
            {
                nums[place]=nums[i];
                place++;
            }
        }
        return place;
    }
}