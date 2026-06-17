class Solution {
    public boolean canPartition(int[] nums) {
        // first we are trying to figure out the sum as the target can be decided
        int sum = 0;

        for(int num : nums) 
            sum += num;
        
        if(sum%2 != 0) // if the sum is not even ,the partition cannot be done 
        // ((sum & 1) == 1) bitwise way of even odd, 
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length+1][target+1];

        // fill the column with true, as base case
        for(int i=0; i<=nums.length; i++)
            dp[i][0] = true;
        
        // why not fi
        // for(int j=0; j<= target; j++)
        //     dp[0][j] = true;

        for(int i=1; i <= nums.length; i++) {
            int current = nums[i - 1];
            for(int j=0; j <= target; j++) {
                // not take / skip
                dp[i][j] = dp[i-1][j];

                // take
                if(j >= current) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-current];
                }
            }
        }
        return dp[nums.length][target];
    }
}