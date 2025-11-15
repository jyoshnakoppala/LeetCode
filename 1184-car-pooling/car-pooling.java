class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)-> a[2]-b[2]);
        int passengers=0;
        for(int[] trip:trips)
        {
            int num=trip[0];
            int start=trip[1];
            int end=trip[2];

            while(!pq.isEmpty() && start>=pq.peek()[2])
            {
                passengers -= pq.poll()[0];
            }

            passengers += num;  
            pq.offer(trip); 

            if (passengers > capacity) return false;
        }
        return true;
    }
}