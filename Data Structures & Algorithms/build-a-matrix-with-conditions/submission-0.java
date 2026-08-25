class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);
        // A cycle means no valid matrix exists
        if (rowOrder.length == 0 || colOrder.length == 0) {
            return new int[0][0];
        }
        int[] colPosition = new int[k + 1];
        for (int col = 0; col < k; col++) {
            colPosition[colOrder[col]] = col;
        }
        int[][] matrix = new int[k][k];
        for (int row = 0; row < k; row++) {
            int value = rowOrder[row];
            matrix[row][colPosition[value]] = value;
        }
        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] indegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] condition : conditions) {
            int before = condition[0];
            int after = condition[1];
            graph[before].add(after);
            indegree[after]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int value = 1; value <= k; value++) {
            if (indegree[value] == 0) {
                queue.offer(value);
            }
        }
        int[] order = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;
            for (int next : graph[current]) {
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == k ? order : new int[0];
    }
}