class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            map.put(nums[i], map.get(nums[i])+1);
            else
            map.put(nums[i], 1);
        }
        int[] keys=map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keys);

        int index=0;
        for(int key: keys)
        {
            int c=map.get(key);
            while(c-->0)
            {
                nums[index++]=key;
            }
        }
        return nums;
    }
}