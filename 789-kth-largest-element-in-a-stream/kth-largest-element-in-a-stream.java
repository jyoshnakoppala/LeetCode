class KthLargest {
    PriorityQueue<Integer> minheap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<Integer>();
        for(int i=0; i<nums.length && i< k;i++)
        {
             minheap.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++)
        {
            if(nums[i]>minheap.peek())
            {
                minheap.poll();
                minheap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(minheap.size()<k)
        {
            minheap.add(val);
            return minheap.peek();
        }
        minheap.add(val);
        minheap.poll();
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */