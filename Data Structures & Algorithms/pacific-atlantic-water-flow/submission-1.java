class Solution {

    int numRows = 0;
    int numCols = 0;
    int[][] landinghieghts;
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        landinghieghts = matrix;
        Deque<int[]> pacificQueue = new ArrayDeque<>();
        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[] { i, 0 });
            atlanticQueue.offer(new int[] { i, numCols - 1 });
        }
        for (int i = 0; i < numCols; i++) {
            pacificQueue.offer(new int[] { 0, i });
            atlanticQueue.offer(new int[] { numRows - 1, i });
        }
        boolean[][] pacificReachable = bfs(pacificQueue);
        boolean[][] atlanticReachable = bfs(atlanticQueue);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    public boolean[][] bfs(Deque<int[]> queue) {
        boolean[][] visited = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            visited[currX][currY] = true;
            for (int[] dir : dirs) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];
                if (newX < 0 || newX >= numRows || newY < 0 || newY >= numCols || visited[newX][newY]
                        || landinghieghts[newX][newY] < landinghieghts[currX][currY]) {
                    continue;
                }
                queue.offer(new int[] { newX, newY });
            }
        }
        return visited;
    }
}