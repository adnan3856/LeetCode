class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        int rows  = mat.length;
        int cols = mat[0].length;

        int distance[][] = new int[rows][cols];

        for(int row=0; row < rows; row++) {
            for(int col=0; col < cols; col++) {
                if(mat[row][col] == 0) 
                    queue.offer(new int[]{row, col});
                else
                    distance[row][col] = -1;
            }
        }

        int[][] directions = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for(int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];

                if(nr >=0 && nc >= 0 && nr < mat.length && nc < mat[0].length && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[row][col] + 1;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return distance;
    }
}