class Solution {
    private boolean ispossible(int dis, int[] position, int m)
    {
        int noofballs=1;
        int last=position[0];
        for(int i=1; i<position.length;i++)
        {
            if(position[i]-last>=dis)
            {
                noofballs+=1;
                last=position[i];
            }
            if(noofballs>=m) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int low=1;
        int res=low;
        int high=position[n-1]-position[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(ispossible(mid, position, m))
            {
                res=mid;
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return res;
    }
}