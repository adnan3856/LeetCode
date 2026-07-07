class Solution {

    private final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int island = 0;
        for(int row=0; row<rows; row++) {
            for(int col=0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    island++;
                    dfs(grid, row, col);
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int row, int col) {
        // validate
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return;
        
        //visit
        grid[row][col] = '0';

        // explore
        for(int[] dir : DIRS)
            dfs(grid, row+dir[0], col+dir[1]);
        // dfs(grid, row+1, col);
        // dfs(grid, row-1, col);
        // dfs(grid, row, col+1);
        // dfs(grid, row, col-1);
    }
}