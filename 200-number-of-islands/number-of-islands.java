class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        // Loop through every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If we find land, it's a new island!
                if (grid[i][j] == '1') {
                    count++;
                    // Call DFS to "sink" the entire island
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        // Base cases: Stop if we go out of bounds or hit water ('0')
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0') {
            return;
        }

        // "Sink" the current cell so we don't visit it again
        grid[row][col] = '0';

        // Recursively visit all 4 neighboring directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}