class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] sorted = new int[m][4];
        // {from, to, weight, originalIndex}
        for (int i = 0; i < m; i++) {
            sorted[i] = new int[] {edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[2], b[2]));
        int baseWeight = mst(n, sorted, -1, -1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (mst(n, sorted, i, -1) > baseWeight) {
                critical.add(sorted[i][3]);
            } else if (mst(n, sorted, -1, i) == baseWeight) {
                pseudo.add(sorted[i][3]);
            }
        }
        return Arrays.asList(critical, pseudo);
    }

    private int mst(int n, int[][] edges, int skip, int force) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        int used = 0;
        // Force this edge into the MST
        if (force != -1) {
            int[] edge = edges[force];
            uf.union(edge[0], edge[1]);
            weight += edge[2];
            used++;
        }
        // Build the remaining MST
        for (int i = 0; i < edges.length; i++) {
            if (i == skip || i == force) {
                continue;
            }
            int[] edge = edges[i];
            if (uf.union(edge[0], edge[1])) {
                weight += edge[2];
                used++;
            }
        }
        return used == n - 1 ? weight : Integer.MAX_VALUE;
    }

    private static class UnionFind {
        private final int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }
        int find(int node) {
            if (parent[node] < 0) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        boolean union(int first, int second) {
            int rootFirst = find(first);
            int rootSecond = find(second);
            if (rootFirst == rootSecond) {
                return false;
            }
            // More negative value means a larger component
            if (parent[rootFirst] > parent[rootSecond]) {
                int temp = rootFirst;
                rootFirst = rootSecond;
                rootSecond = temp;
            }
            parent[rootFirst] += parent[rootSecond];
            parent[rootSecond] = rootFirst;
            return true;
        }
    }
}