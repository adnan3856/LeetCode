class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=1; i<=amount; i++)
            dp[0][i] = amount+1;

        for(int i=1; i<=coins.length; i++) {
            int coin = coins[i-1];
            for(int j=0; j<=amount; j++) {
                dp[i][j] = dp[i-1][j];

                if(j >=coin)
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-coin]);
            }
        }
        
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];

        // int[][] dp = new int[coins.length+1][amount+1];

        // // can 0 coins make the amount, no, so, infinity or cannot be done
        // for(int i=1; i<=amount; i++) {
        //     dp[0][i] = amount+1;
        // }

        // for(int i=1; i<=coins.length; i++) {
        //     int coin = coins[i-1];
        //     for(int j=0; j<=amount; j++) {
        //         // not take
        //         dp[i][j] = dp[i-1][j];

        //         // take
        //         if(j >= coin)
        //             dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j- coin]);
        //     }
        // }
        // return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}