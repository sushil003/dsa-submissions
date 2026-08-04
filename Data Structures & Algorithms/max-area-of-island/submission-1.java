class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count = 0;
                dfs(i, j, grid);
                maxArea = Math.max(maxArea, count);
            }
        }
        return maxArea;
    }

    public void dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        count++;
        grid[row][col] = 0;
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}