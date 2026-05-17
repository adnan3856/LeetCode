import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        // Queue will store the coordinates of rotten oranges: new int[]{row, col}
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Scan the grid to find all initially rotten oranges and count fresh ones
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col}); // Add all sources of rot
                } else if (grid[row][col] == 1) {
                    freshOranges++; // Count fresh oranges to verify at the end
                }
            }
        }
        
        // If there are no fresh oranges to begin with, 0 minutes have elapsed
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};
        
        // Step 2: Start Multi-Source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAnyThisMinute = false;
            
            // Process all oranges that are currently rotten at THIS level/minute
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                // Check all 4 neighbors
                for (int j = 0; j < 4; j++) {
                    int neighRow = row + deltaRow[j];
                    int neighCol = col + deltaCol[j];
                    
                    // If neighbor is within bounds and is a FRESH orange
                    if (neighRow >= 0 && neighRow < n && 
                        neighCol >= 0 && neighCol < m && 
                        grid[neighRow][neighCol] == 1) {
                        
                        grid[neighRow][neighCol] = 2; // It becomes rotten
                        freshOranges--; // One less fresh orange in the grid
                        queue.add(new int[]{neighRow, neighCol}); // It will rot others next minute
                        rottedAnyThisMinute = true;
                    }
                }
            }
            
            // Only increment time if this round of rotting actually infected new oranges
            if (rottedAnyThisMinute) {
                minutes++;
            }
        }
        
        // Step 3: If there are still fresh oranges left, return -1 (impossible to reach)
        return freshOranges == 0 ? minutes : -1;
    }
}