class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans=0;
        Queue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<nums.length;i++)
        {
            maxheap.offer(nums[i]);
        }
        while(k--!=0)
        {
           ans= maxheap.poll();
        }
        return ans;
    }
}