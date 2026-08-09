class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdJList(numCourses);
        int[] incooming = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            ++incooming[prerequisite[0]];
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < incooming.length; i++) {
            if (incooming[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for (int adj : adjList.get(node)) {
                if (--incooming[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }
        return visited == numCourses;
    }

    private List<List<Integer>> getAdJList(int numCourses) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        return adjList;
    }
}