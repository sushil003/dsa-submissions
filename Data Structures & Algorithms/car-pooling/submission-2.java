class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] time = new int[1001];
        for(int[] trip :trips){
            time[trip[1]] += trip[0];
            time[trip[2]] -= trip[0];
        }  
        int res =0;
        for(int t : time) {
            res +=t;
            if(res > capacity){
                return false;
            }
        }  
        return true;
    }
}