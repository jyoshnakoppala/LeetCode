class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int mini=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>mini)
            profit=Math.max(profit, prices[i]-mini);

             mini=Math.min(prices[i], mini);
        }
        return profit;
    }
}