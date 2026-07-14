class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int profit = 0;
        for(int price : prices) {
            minValue = minValue > price ? price : minValue;

            if(price - minValue > profit) {
                profit = price - minValue;
            }
        }

        return profit;
    }
}