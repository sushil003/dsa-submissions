class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] jobs = new int[n][3];

        // {enqueue time, processing time, original index}
        for (int i = 0; i < n; i++) jobs[i] = new int[] {tasks[i][0], tasks[i][1], i};

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        // Shortest processing time, then smallest index
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            Comparator.comparingInt((int[] job) -> job[1]).thenComparingInt(job -> job[2]));

        int[] order = new int[n];
        int next = 0, completed = 0;
        long time = 0;

        while (completed < n) {
            // Jump to the next task when CPU is idle
            if (heap.isEmpty())
                time = Math.max(time, jobs[next][0]);

            // Add all currently available tasks
            while (next < n && jobs[next][0] <= time) heap.offer(jobs[next++]);

            int[] job = heap.poll();
            time += job[1];
            order[completed++] = job[2];
        }

        return order;
    }
}