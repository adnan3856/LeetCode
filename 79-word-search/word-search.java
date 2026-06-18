class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int row=0; row < rows; row++) {
            for(int col=0; col < cols; col++) {
                if(dfs(board, word, 0, row, col))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        if(index == word.length())
            return true;

        // edge cases
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length )
            return false;
        
        // Character mismatch from board to word
        if(board[row][col] != word.charAt(index))
            return false;

        // choose
        char temp = board[row][col];
        board[row][col] = '#';

        // explore
        boolean found = dfs(board, word, index + 1, row+1, col) ||
                        dfs(board, word, index + 1, row-1, col) ||
                        dfs(board, word, index + 1, row, col + 1) ||
                        dfs(board, word, index + 1, row, col - 1);

        // unchoose
        // Restore original character
        board[row][col] = temp;
        return found;

    }
}