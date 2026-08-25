class Solution {
    public int climbStairs(int n) {
        int prevTwo = 1; // Ways to reach step 0
        int prevOne = 1; // Ways to reach step 1

        for (int step = 2; step <= n; step++) {
            int current = prevOne + prevTwo;
            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }
}