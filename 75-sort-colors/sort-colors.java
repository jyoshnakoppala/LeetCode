class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int index=0;
        for(int i=0;i<=2;i++)
        {
            int c=map.getOrDefault(i, 0);
            while(c-->0)
            {
                nums[index++]=i;
                map.put(i, map.get(i)-1);
            }
        }
    }
}