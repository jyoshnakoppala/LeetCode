class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans=0;
        Queue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            minheap.offer(nums[i]);
            if(minheap.size()>k)
            {
                minheap.poll();
            }
        }
        return minheap.peek();
    }
}