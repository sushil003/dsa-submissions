class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        // distance, node into pq
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { 0, k });
        boolean[] visited = new boolean[n + 1];
        int res = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[1];
            int curDist = curr[0];
            if (visited[currNode])
                continue;
            visited[currNode] = true;
            res = curDist;
            n--;
            if (map.containsKey(currNode)) {
                for (int next : map.get(currNode).keySet()) {
                    queue.offer(new int[] { curDist + map.get(currNode).get(next), next });
                }
            }
        }
        return n == 0 ? res : -1;
    }

}