class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<=0) return new int[0];
        int n=nums.length;
        int ri=0;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0;i<n;i++)
        {
            while(!dq.isEmpty() && dq.peekFirst()<i-k+1)
            dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
            dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1)
            result[ri++]=nums[dq.peekFirst()];
        }
        return result;
    }
}