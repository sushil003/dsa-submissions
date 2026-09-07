class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // No carry needed
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 9 + 1 = 10, keep 0 and carry 1
            digits[i] = 0;
        }
        // If we reach here, all digits were 9
        // Example: 999 -> 1000
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}