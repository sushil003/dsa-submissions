class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval meeting : intervals) {
            // Reuse the room that becomes available earliest
            if (!minHeap.isEmpty() && minHeap.peek() <= meeting.start) {
                minHeap.poll();
            }
            minHeap.offer(meeting.end);
        }
        return minHeap.size();
    }
}