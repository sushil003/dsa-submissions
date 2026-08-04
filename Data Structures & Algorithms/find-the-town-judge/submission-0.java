class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }
        int[] deg = new int[n + 1];
        for (int[] t : trust) {
            deg[t[1]]++;
            deg[t[0]]--;
        }
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}