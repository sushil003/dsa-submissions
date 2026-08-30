class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[queries.length][2];
        // {queryValue, originalIndex}
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        // {intervalLength, intervalEnd}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        int intervalIndex = 0;
        for (int[] queryInfo : sortedQueries) {
            int query = queryInfo[0];
            int originalIndex = queryInfo[1];
            // Add intervals that have started
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int left = intervals[intervalIndex][0];
                int right = intervals[intervalIndex][1];
                int length = right - left + 1;
                minHeap.offer(new int[] {length, right});
                intervalIndex++;
            }
            // Remove intervals that ended before the query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                answer[originalIndex] = minHeap.peek()[0];
            }
        }
        return answer;
    }
}