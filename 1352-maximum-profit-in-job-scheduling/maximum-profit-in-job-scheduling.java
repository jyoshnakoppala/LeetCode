class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
      int n=profit.length;
      int[][] jobs=new int[n][3];

      int[] dp=new int[n+1];

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

      dp[n]=0;

      for(int i=n-1;i>=0;i--)
      {
        int nextIndex = binarySearch(sorted, jobs[i][1]);
        int take=jobs[i][2]+dp[nextIndex];
        int nottake=dp[i+1];
        dp[i]=Math.max(take, nottake);
      }
      return dp[0];
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