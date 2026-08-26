class Solution {
    public int rob(int[] nums) {
        int prevTwo = 0; // Maximum before previous house
        int prevOne = 0; // Maximum before current house
        for (int money : nums) {
            int current = Math.max(prevOne, // Skip current house
                prevTwo + money // Rob current house
            );
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}