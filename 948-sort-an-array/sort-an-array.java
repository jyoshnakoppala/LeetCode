class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int min=nums[0]; int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            map.put(nums[i], map.get(nums[i])+1);
            else
            map.put(nums[i], 1);

            if(nums[i]>max)
            max=nums[i];

            if(nums[i]<min)
            min=nums[i];
        }
        int index=0;
        for(int i=min; i<=max; i++)
        {
            if(map.containsKey(i))
            {
                while(map.get(i)>0)
                {
                nums[index]= i;
                index++;
                map.put(i, map.get(i)-1);
                }
            }
        }
        return nums;
    }
}