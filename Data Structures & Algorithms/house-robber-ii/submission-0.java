class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), // Exclude last
            robRange(nums, 1, n - 1) // Exclude first
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int prevTwo = 0;
        int prevOne = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prevOne, // Skip current house
                prevTwo + nums[i] // Rob current house
            );
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}