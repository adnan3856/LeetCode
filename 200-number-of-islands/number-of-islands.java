import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(visited[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int ro, int co, int[][] visited, char[][] grid) {
        visited[ro][co] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        // Direction arrays for Up, Down, Left, Right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            // Check all 4 cardinal directions
            for(int i = 0; i < 4; i++) {
                int neighRow = row + dRow[i];
                int neighCol = col + dCol[i];

                // Corrected boundary checks: both row and col must be >= 0
                if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m
                    && grid[neighRow][neighCol] == '1' && visited[neighRow][neighCol] == 0) {
                        visited[neighRow][neighCol] = 1;
                        queue.add(new Pair(neighRow, neighCol));
                }
            }
        }
    }
}