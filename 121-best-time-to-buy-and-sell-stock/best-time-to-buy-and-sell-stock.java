class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for(int price : prices) {
            if(min > price)
                min = price;

            if(profit < price - min)
                profit = price - min;
        }
        return profit;
    }
}