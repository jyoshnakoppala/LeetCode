class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops=new int[1001];

        for(int[] trip: trips)
        {
            stops[trip[1]]+=trip[0];
            stops[trip[2]]-=trip[0];
        }
        int passengers=0;
        for(int x:stops)
        {
            passengers+=x;
            if(passengers>capacity) return false;
        }
        return true;
    }
}