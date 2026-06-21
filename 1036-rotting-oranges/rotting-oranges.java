class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int col=0; col < grid[0].length; col++) {
                if(grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
                if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0)
            return 0;
        
        int minutes = 0;

        int[][] directions = {{+1, 0} , {-1, 0}, {0, +1}, {0, -1}};

        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            boolean somethingRotten = false;

            for(int i=0; i<size; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];


                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;

                        queue.offer(new int[]{nr, nc});

                        somethingRotten = true;
                    }
                }
            }
            if(somethingRotten)
                minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}