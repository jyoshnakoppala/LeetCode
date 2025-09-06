class Solution {
    public int maxProfit(int[] prices) {
       int buy=prices[0];
       int ans=0;
       for(int i=1;i<prices.length;i++)
       {
        if(prices[i]>buy)
        ans=Math.max(ans, prices[i]-buy);
        else
        buy=Math.min(prices[i], buy);
       }
       return ans;
    }
}