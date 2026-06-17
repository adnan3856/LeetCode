class Solution {
    public int coinChange(int[] coins, int amount) {
         
         int[][] dp = new int[coins.length + 1][amount+1];

         // Initialize impossible states
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }


        for(int i=1; i<=coins.length; i++) {
            int coin = coins[i-1];
            for(int j=0; j<= amount; j++) {

                dp[i][j] = dp[i-1][j];

                if(j >= coin) {
                    dp[i][j] = Math.min (dp[i-1][j], 1 + dp[i][j - coin]);
                }
            }
        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}