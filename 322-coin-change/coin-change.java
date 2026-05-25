class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int ans = helper(coins, amount, dp, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int[] coins, int target, int[][] dp , int index) {
        if(target == 0)
            return 0;
        if(index == coins.length && target != 0)
            return Integer.MAX_VALUE;
        if(dp[index][target] != -1)
            return dp[index][target];
        
        int notTake = helper(coins, target, dp, index+1);
        int take = Integer.MAX_VALUE;

        if(coins[index] <= target) {
            take = helper(coins, target - coins[index], dp, index);
            if(take != Integer.MAX_VALUE)
                take += 1;
        }
        dp[index][target] = Math.min(take, notTake);
        return dp[index][target];
    }
}