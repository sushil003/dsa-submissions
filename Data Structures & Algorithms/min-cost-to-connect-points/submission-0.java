class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0;
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for (int count = 0; count < n; count++) {
            int node = -1;

            // Pick cheapest unvisited point
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (node == -1 || minDist[i] < minDist[node])) {
                    node = i;
                }
            }

            visited[node] = true;
            cost += minDist[node];

            // Update cost to connect remaining points
            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(points[node][0] - points[next][0])
                        + Math.abs(points[node][1] - points[next][1]);

                    minDist[next] = Math.min(minDist[next], distance);
                }
            }
        }

        return cost;
    }
}