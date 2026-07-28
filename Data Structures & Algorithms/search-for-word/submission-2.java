class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
            || board[i][j] != word.charAt(idx)) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, i + 1, j, idx + 1, word) || search(board, i - 1, j, idx + 1, word)
            || search(board, i, j + 1, idx + 1, word) || search(board, i, j - 1, idx + 1, word)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}