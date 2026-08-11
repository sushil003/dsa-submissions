class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        Map<Integer,Set<Integer>> adj = new HashMap<>();
        Map<Integer,Set<Integer>> preMap = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.put(i,new HashSet<Integer>());
            preMap.put(i,new HashSet<Integer>());
        }
        for(int[] p : prerequisites){
            ++indegree[p[1]];
            adj.get(p[0]).add(p[1]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int nei : adj.get(node)){
                preMap.get(nei).add(node);
                preMap.get(nei).addAll(preMap.get(node));
                if(--indegree[nei] == 0) {
                queue.offer(nei);
               }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            if(preMap.get(q[1]).contains(q[0])){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}