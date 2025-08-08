class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num: nums)
        {
            int index=Math.abs(num)-1;

            if(nums[index]<0) list.add(Math.abs(num));
            else
            nums[index]=nums[index]*(-1);
    
        }
        return list;
    }
}