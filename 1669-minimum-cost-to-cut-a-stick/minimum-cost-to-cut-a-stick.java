class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutlist=new ArrayList<>();
        for(int cut: cuts)
        cutlist.add(cut);

        cutlist.add(0);
        cutlist.add(n);

        Collections.sort(cutlist);
        int c=cuts.length;

        int[][] dp=new int[c+2][c+2];

        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=c;j++)
            {
                if(i>j) continue;
                int minCost=Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++)
                 {
                     int cost = cutlist.get(j + 1) - cutlist.get(i - 1)
                     + dp[i][ind-1]
                     + dp[ind+1][j];
                     minCost = Math.min(minCost, cost);

                     dp[i][j]=minCost;
                  }
            }
         }
         return dp[1][c];
}
}