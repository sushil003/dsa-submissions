class Solution {
    int[] d = {0, 1, 0, -1, 0};
    public void islandsAndTreasure(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(i * n + j);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currX = curr / n;
            int currY = curr % n;
            for (int i = 0; i < 4; i++) {
                int newX = currX + d[i];
                int newY = currY + d[i + 1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && rooms[newX][newY] == Integer.MAX_VALUE) {
                    rooms[newX][newY] = 1 + rooms[currX][currY];
                    queue.offer(newX * n + newY);
                }
            }
        }
    }
}
