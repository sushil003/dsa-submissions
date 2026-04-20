class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int a : asteroids){
            if(a > 0){
                queue.push(a);
            } else {
                  while(!queue.isEmpty() && queue.peek() > 0 && queue.peek() < Math.abs(a))
                    queue.pop();
               if(queue.isEmpty() || queue.peek() < 0){
                    queue.push(a);
                }else if(a + queue.peek() == 0){
                    queue.pop();
                }
            }
        }
        int[] res = new int[queue.size()];
        for(int i= res.length-1; i>=0; i--){
            res[i] = queue.pop();
        }
        return res;
    }
}