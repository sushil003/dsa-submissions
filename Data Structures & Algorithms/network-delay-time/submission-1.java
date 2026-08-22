class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : times) graph[edge[0]].add(new int[] {edge[1], edge[2]});

        // {total time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] {0, k});

        boolean[] visited = new boolean[n + 1];
        int reached = 0, delay = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if (visited[node])
                continue;

            visited[node] = true;
            reached++;
            delay = time;

            for (int[] next : graph[node]) {
                if (!visited[next[0]]) {
                    pq.offer(new int[] {time + next[1], next[0]});
                }
            }
        }

        return reached == n ? delay : -1;
    }
}