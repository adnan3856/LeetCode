class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0) return 0;

        int minutes=0;
        int[][] directions = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            boolean rotten = false;
            for(int i = 0; i< size; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc <grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                        rotten = true;
                    }
                }
            }
            if(rotten)
                minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}