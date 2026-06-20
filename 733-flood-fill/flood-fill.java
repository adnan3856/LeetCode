class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // validate // visit // explore // return 

        int originalColor = image[sr][sc];

        if(originalColor == color)
            return image;
        
        dfs(image, sr, sc, originalColor, color);
        // return
        return image;
    }

    public void dfs(int[][] image, int row, int col, int originalColor, int color) {

        // validate
        if(row < 0 || col < 0 ||
            row >= image.length || col >= image[0].length ||
                image[row][col] != originalColor) {
                    return;
                }
        
        // visit
        image[row][col] = color;

        // explore all sides
        dfs(image, row + 1, col, originalColor, color);
        dfs(image, row - 1, col, originalColor, color);
        dfs(image, row, col + 1, originalColor, color);
        dfs(image, row, col - 1, originalColor, color);
    }
}