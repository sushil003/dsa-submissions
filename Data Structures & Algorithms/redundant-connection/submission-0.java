class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);
            if (x != y) {
                parent[x] = y;
            } else {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;
    }

    private int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }
}