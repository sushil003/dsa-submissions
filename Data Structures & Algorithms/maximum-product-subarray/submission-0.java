class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            // Negative number swaps maximum and minimum
            if (number < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(number, currentMax * number);
            currentMin = Math.min(number, currentMin * number);
            result = Math.max(result, currentMax);
        }
        return result;
    }
}