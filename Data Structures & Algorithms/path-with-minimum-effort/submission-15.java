class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // {effort, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        effort[0][0] = 0;
        minHeap.offer(new int[] {0, 0, 0});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currEffort = current[0];
            int row = current[1];
            int col = current[2];
            // Ignore an outdated heap entry.
            if (currEffort > effort[row][col]) {
                continue;
            }
            if (row == rows - 1 && col == cols - 1) {
                return currEffort;
            }
            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                    continue;
                }
                int edgeEffort = Math.abs(heights[row][col] - heights[nextRow][nextCol]);
                // Path cost is its largest edge, not the sum of its edges.
                int nextEffort = Math.max(currEffort, edgeEffort);

                if (nextEffort < effort[nextRow][nextCol]) {
                    effort[nextRow][nextCol] = nextEffort;
                    minHeap.offer(new int[] {nextEffort, nextRow, nextCol});
                }
            }
        }

        return 0;
    }
}