class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        int[] cur=new int[m];

        for(int i=0;i<m;i++)
        prev[i]=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0) cur[j]=grid[0][0];
                else
                {
                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? cur[j - 1] : Integer.MAX_VALUE;

                    int mini = Math.min(up, left);
                    cur[j] = grid[i][j] + mini;

                }
            }
            int[] temp=prev;
            prev=cur;
            cur=temp;
        }
        return prev[m-1];
    }
}