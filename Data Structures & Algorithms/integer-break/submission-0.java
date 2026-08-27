class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int sum = 2; sum <= n; sum++) {
            for (int first = 1; first < sum; first++) {
                int remaining = sum - first;
                dp[sum] = Math.max(dp[sum], first * Math.max(remaining, dp[remaining]));
            }
        }
        return dp[n];
    }
}