/**

https://www.youtube.com/watch?v=eq6dAJefOqc

**/
class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();
        long l = max;
        long r = sum;
        while(l <= r) {
            long mid = (l+r)/2;
            if(valid(mid,nums,m)){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    
    private boolean valid(long target,int[] nums,int m) {
        int total = 0;
        int count = 1;
        for(int num : nums) { 
            total += num;
            if(total > target){  
                total = num;
                count++;
            }
        }
        return count <= m;
    }
}