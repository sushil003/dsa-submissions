class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prevTwo = 0; // Cost to reach step 0
        int prevOne = 0; // Cost to reach step 1
        for (int step = 2; step <= cost.length; step++) {
            int current = Math.min(prevOne + cost[step - 1], prevTwo + cost[step - 2]);
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}