class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = Arrays.stream(weights).sum();
        while(left <= right){
            int mid = left + (right-left)/2;
            boolean can = canShip(weights,mid,days);
            if(can){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int mid, int D){
        int day = 1;
        int w =0;
        for(int i=0; i<weights.length; i++){
            if(weights[i] > mid || day > D) return false;
            if(w + weights[i] > mid){
                w = weights[i];
                day++;
            } else {
                w +=weights[i];
            }
        }
        return day <= D;
    }
}