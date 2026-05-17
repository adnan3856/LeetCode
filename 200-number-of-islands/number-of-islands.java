class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islandCount = 0;
        int[] deltaRow = {-1, 0, +1, 0}; // up, left, down, right
        int[] deltaCol = {0, +1, 0, -1};

        for(int row=0; row< n; row++) {
            for(int col=0; col< m; col++) {
                if(grid[row][col] == '1') {
                    islandCount++;
                    dfs(row, col, grid, deltaRow, deltaCol);
                }
            }
        }
        return islandCount;
    }

    public void dfs(int row, int col, char[][] grid, int[] deltaRow, int[] deltaCol) {
        grid[row][col] = '0'; // if visited then mark it as water, so we dont visit again

        for(int i=0; i<4; i++) {
            int neighRow = row + deltaRow[i];
            int neighCol = col + deltaCol[i];

            if(neighRow >= 0 && neighRow < grid.length &&
                neighCol >= 0 && neighCol < grid[0].length &&
                    grid[neighRow][neighCol] == '1') {
                        dfs(neighRow, neighCol, grid, deltaRow, deltaCol);
                    }
        }
    }
}