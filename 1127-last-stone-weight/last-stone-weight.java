class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a, b)->(b-a));

        for(int stone:stones)
        maxheap.offer(stone);

        while(maxheap.size()>1)
        {
            int num1=maxheap.poll();
            int num2=maxheap.poll();

            if(num1!=num2) 
            maxheap.offer(num1-num2);
        }
        if(maxheap.size()==0) return 0;
        else return maxheap.poll();
    }
}