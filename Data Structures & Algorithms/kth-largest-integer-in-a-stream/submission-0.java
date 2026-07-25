class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            queue.offer(num);
        }
    }
    public int add(int val) {
        queue.offer(val);
         while(!queue.isEmpty() && queue.size()>k) {
            queue.poll();
         }
        return queue.peek();
    }
}