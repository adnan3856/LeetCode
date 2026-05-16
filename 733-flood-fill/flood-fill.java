class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] res = image;
        int initColor = res[sr][sc];
        // up, left, down, right
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaColumn = {0, +1, 0, -1};
        dfs(sr, sc, image, res, color, deltaRow, deltaColumn, initColor);
        return res;
    }

    public void dfs(int row, int col, int[][] image, int[][] res, int newColor, int[] deltaRow, int[] deltaColumn, int initColor ){
        res[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++) {
            int neighRow = row + deltaRow[i];
            int neighCol = col + deltaColumn[i];

            if(neighRow >= 0 && neighRow < n && neighCol >= 0 && neighCol < m
            && image[neighRow][neighCol] == initColor
            && res[neighRow][neighCol] != newColor) {
                dfs(neighRow, neighCol, image, res, newColor, deltaRow, deltaColumn, initColor);
            }
        }
    }
}