class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int number : nums) {
            total += number;
        }
        // An odd total cannot be divided equally
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int number : nums) {
            // Traverse backward to use each number only once
            for (int sum = target; sum >= number; sum--) {
                dp[sum] = dp[sum] || dp[sum - number];
            }
            if (dp[target]) {
                return true;
            }
        }
        return false;
    }
}