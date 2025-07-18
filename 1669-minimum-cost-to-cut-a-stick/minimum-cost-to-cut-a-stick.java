class Solution {
    private int findans(int i, int j, ArrayList<Integer> cutlist, int[][] dp)
    {
        if(i>j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int minCost=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++)
        {
            int cost = cutlist.get(j + 1) - cutlist.get(i - 1)
                     + findans(i, ind - 1, cutlist, dp)
                     + findans(ind + 1, j, cutlist, dp);
            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutlist=new ArrayList<>();
        for(int cut: cuts)
        cutlist.add(cut);

        cutlist.add(0);
        cutlist.add(n);

        Collections.sort(cutlist);
        int c=cuts.length;

        int[][] dp=new int[c+2][c+2];

        for (int[] row : dp)
        Arrays.fill(row, -1);

        return findans(1, c, cutlist, dp);
    }
}