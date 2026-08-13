class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Single node is itself the minimum height tree root
        if (n == 1)
            return List.of(0);
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Build undirected graph and calculate degree of each node
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // Initial leaves are nodes with degree 1
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        // Remove leaves layer by layer until only
        // the center 1 or 2 nodes remain
        while (n > 2) {
            int size = queue.size();
            n -= size;
            // Process only the current layer of leaves
            while (size-- > 0) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    // Remove current leaf's connection
                    // If neighbor becomes a leaf, add it
                    if (--degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        // Remaining 1 or 2 nodes are the MHT roots
        return new ArrayList<>(queue);
    }
}