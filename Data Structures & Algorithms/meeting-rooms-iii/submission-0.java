class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        // {availableTime, roomNumber}
        PriorityQueue<long[]> rooms = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        for (int room = 0; room < n; room++) {
            rooms.offer(new long[] {0, room});
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long duration = (long) meeting[1] - meeting[0];
            // Mark every already-free room as available at start
            while (rooms.peek()[0] < start) {
                long[] room = rooms.poll();
                room[0] = start;
                rooms.offer(room);
            }
            // Lowest available room or earliest finishing busy room
            long[] room = rooms.poll();
            room[0] += duration;
            count[(int) room[1]]++;
            rooms.offer(room);
        }
        int answer = 0;
        for (int room = 1; room < n; room++) {
            if (count[room] > count[answer]) {
                answer = room;
            }
        }
        return answer;
    }
}