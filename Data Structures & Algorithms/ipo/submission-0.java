class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][];
        for(int i=0;i<n;i++) projects[i] = new int[]{capital[i],profits[i]};
        Arrays.sort(projects,Comparator.comparingInt(p->p[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int i =0;
        while(k-- > 0){
            while(i < n && projects[i][0] <= w){
                heap.offer(projects[i++][1]);
            }
            if(heap.isEmpty()) break;
            w+=heap.poll();
        }
        return w;
    }
}