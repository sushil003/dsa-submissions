class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        // {required capital, profit}
        for (int i = 0; i < n; i++)
            projects[i] = new int[] { capital[i], profits[i] };
        Arrays.sort(projects, Comparator.comparingInt(p -> p[0]));
        // Highest profit among currently affordable projects
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (k-- > 0) {
            // Add all affordable projects
            while (i < n && projects[i][0] <= w)
                heap.offer(projects[i++][1]);
            if (heap.isEmpty())
                break;
            // Choose the most profitable project
            w += heap.poll();
        }
        return w;
    }
}