class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        // {time, row, column}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int time = current[0];
            int row = current[1];
            int col = current[2];
            if (row == n - 1 && col == n - 1) {
                return time;
            }
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n
                    || visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                int nextTime = Math.max(time, grid[nextRow][nextCol]);
                minHeap.offer(new int[] {nextTime, nextRow, nextCol});
            }
        }
        return -1;
    }
}