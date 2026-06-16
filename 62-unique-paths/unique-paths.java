class Solution {
    public int uniquePaths(int m, int n) {
        // Define state: dp[i][j] = number of ways to reach cell (i,j)
        int[][] dp = new int[m][n];

        // Base case
        // First row
        for(int i=0; i< n; i++)
            dp[0][i] = 1;
        
        // First column
        for(int i=0; i<m; i++)
            dp[i][0] = 1;

        // Define Choices: To reach (i,j), the robot can come from:
        // Top    -> (i-1,j)
        // Left   -> (i,j-1)
        for(int i=1; i<m; i++) { // row
            for(int j=1; j<n; j++) { // column
                // Top + left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}


