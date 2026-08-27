class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int sum = 1; sum <= n; sum++) {
            for (int number = 1; number * number <= sum; number++) {
                int square = number * number;
                dp[sum] = Math.min(dp[sum], 1 + dp[sum - square]);
            }
        }
        return dp[n];
    }
}