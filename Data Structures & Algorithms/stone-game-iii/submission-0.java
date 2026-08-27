class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        // dp[i] = maximum score advantage starting at index i
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int score = 0;
            // Take 1, 2, or 3 stones
            for (int take = 1; take <= 3 && i + take <= n; take++) {
                score += stoneValue[i + take - 1];
                dp[i] = Math.max(dp[i], score - dp[i + take]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        }
        if (dp[0] < 0) {
            return "Bob";
        }
        return "Tie";
    }
}