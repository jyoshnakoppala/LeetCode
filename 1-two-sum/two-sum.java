class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int current=nums[i];
            int complement=target-current;

            if(index.containsKey(complement)){
                return new int[]{
                    index.get(complement),i};
                }
                index.put(current,i);

            }
        return new int[0];
    }
}