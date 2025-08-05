class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int curcount=0, longest=1;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums)
        {
            set.add(num);
        }
        for(int num: set)
        {
            if(!set.contains(num-1))
            {
                while(set.contains(num))
                {
                    curcount++;
                    num++;
                }
                longest=Math.max(longest, curcount);
                curcount=0;
            }
        }
        return longest;
    }
}