class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] incooming = new int[numCourses];
        List<List<Integer>> adjList = getAdjList(numCourses);
        for (int[] prerequisite : prerequisites) {
            ++incooming[prerequisite[0]];
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < incooming.length; i++) {
            if (incooming[i] == 0) {
                deque.offer(i);
            }
        }
        int visited = 0;
        int idx = 0;
        while (!deque.isEmpty()) {
            int node = deque.poll();
            visited++;
            res[idx++] = node;
            for (int adj : adjList.get(node)) {
                if (--incooming[adj] == 0) {
                    deque.offer(adj);
                }
            }
        }
        return visited == numCourses ? res : new int[] {};
    }
    private List<List<Integer>> getAdjList(int numCourses) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        return adjList;
    }
}