class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] res = image; // it is generally a good practice to not change the given data
        int initColor = res[sr][sc];
        
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};            
        dfs(sr, sc, image, res, deltaRow, deltaCol, initColor, color);
        return res;
    }

    public void dfs(int row, int col, int[][] image, int[][] res, int[] deltaRow, int[] deltaCol, int initColor, int newColor) {
        res[row][col] = newColor; // visited row, col

        for(int i = 0; i< 4; i++) {
            int neighRow = row + deltaRow[i];
            int neighCol = col + deltaCol[i];

            if(neighRow >= 0 && neighRow < image.length &&
                neighCol >=0 && neighCol < image[0].length &&
                 image[neighRow][neighCol] == initColor &&
                    res[neighRow][neighCol] != newColor) {
                        dfs(neighRow, neighCol, image, res, deltaRow, deltaCol, initColor, newColor);
                    }
        }
    }

}