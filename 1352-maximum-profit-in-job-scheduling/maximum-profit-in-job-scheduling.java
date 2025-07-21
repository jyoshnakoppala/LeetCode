class Solution {
    private int findans(int[][] jobs, int[] sorted, int ind, int[] dp)
    {
        if(ind==jobs.length) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int nextIndex = binarySearch(sorted, jobs[ind][1]);
        int take=jobs[ind][2]+findans(jobs, sorted, nextIndex, dp);
        int nottake=findans(jobs, sorted, ind+1, dp);
        return dp[ind]=Math.max(take, nottake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      int n=profit.length;
      int[][] jobs=new int[n][3];

      int[] dp=new int[n];
      Arrays.fill(dp, -1);

      for(int i=0;i<n;i++)
      {
        jobs[i][0]=startTime[i];
        jobs[i][1]=endTime[i];
        jobs[i][2]=profit[i];
      }
      Arrays.sort(jobs, (a,b)->Integer.compare(a[0],b[0]));
      int[] sorted=new int[n];
      for(int i=0;i<n;i++)
      sorted[i]=jobs[i][0];

      return findans(jobs, sorted, 0, dp);
    }
    private int binarySearch(int[] start, int target) {
        int low = 0, high = start.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (start[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}