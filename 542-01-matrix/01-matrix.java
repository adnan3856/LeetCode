class Solution {

    public int[][] updateMatrix(int[][] mat) {

        // Queue is used for BFS.
        // Why Queue?
        // BFS explores level by level.
        // In this problem we want the shortest distance from every 1 to nearest 0.
        // BFS naturally gives shortest path in an unweighted grid.
        Queue<int[]> queue = new LinkedList<>();


        // Result matrix.
        // Why separate matrix?
        // We need to store distance of every cell from nearest 0.
        //
        // Meaning:
        // visited[row][col]
        // =
        // distance from nearest 0
        //
        // Initially:
        // 0 cells -> distance = 0 (default value)
        // 1 cells -> distance unknown
        int[][] visited = new int[mat.length][mat[0].length];


        // Traverse entire matrix once.
        for (int row = 0; row < mat.length; row++) {

            for (int col = 0; col < mat[0].length; col++) {

                // Multi-source BFS
                //
                // Why add all 0s to queue?
                //
                // Instead of running BFS from every 1,
                // we start BFS from all 0s simultaneously.
                //
                // This guarantees the first time we reach a 1,
                // we have found its shortest distance from a 0.
                if (mat[row][col] == 0) {

                    // Store row and column together.
                    //
                    // int[] = {row, col}
                    //
                    // Example:
                    // {2,3}
                    // means cell (2,3)
                    queue.offer(new int[]{row, col});
                }
                else {

                    // Mark all 1s as unvisited.
                    //
                    // Why -1?
                    //
                    // Because distance is not calculated yet.
                    //
                    // Later:
                    // -1 -> unvisited
                    //  0 -> zero cell
                    //  1 -> distance 1 from nearest zero
                    //  2 -> distance 2 from nearest zero
                    visited[row][col] = -1;
                }
            }
        }


        // Directions array used for traversing neighbors.
        //
        // Why?
        //
        // Instead of writing:
        // up
        // down
        // left
        // right
        //
        // separately, we store them in one array.
        //
        // (+1,0) -> Down
        // (-1,0) -> Up
        // (0,+1) -> Right
        // (0,-1) -> Left
        int[][] directions = {
                {+1, 0},
                {-1, 0},
                {0, +1},
                {0, -1}
        };


        // Standard BFS loop.
        //
        // Continue until all reachable cells are processed.
        while (!queue.isEmpty()) {

            // Remove front element from queue.
            //
            // Queue ensures FIFO order.
            //
            // This guarantees level-order traversal.
            int[] current = queue.poll();


            // Current cell coordinates.
            int row = current[0];
            int col = current[1];


            // Visit all 4 neighbors.
            for (int[] direction : directions) {

                // Neighbor row.
                int nr = row + direction[0];

                // Neighbor column.
                int nc = col + direction[1];


                // Conditions:
                //
                // 1. Inside matrix boundaries.
                // 2. Neighbor not visited yet.
                //
                // visited[nr][nc] == -1
                //
                // means:
                // distance not calculated yet.
                if (nr >= 0
                        && nc >= 0
                        && nr < mat.length
                        && nc < mat[0].length
                        && visited[nr][nc] == -1) {

                    // Core BFS formula.
                    //
                    // Current cell already knows its distance.
                    //
                    // Neighbor distance =
                    // Current distance + 1
                    //
                    // Example:
                    //
                    // Current = distance 2
                    //
                    // Neighbor = distance 3
                    visited[nr][nc] =
                            visited[row][col] + 1;


                    // Add neighbor into queue.
                    //
                    // Why?
                    //
                    // This neighbor will now expand further
                    // and update its own neighbors.
                    queue.offer(new int[]{nr, nc});
                }
            }
        }


        // Return distance matrix.
        return visited;
    }
}