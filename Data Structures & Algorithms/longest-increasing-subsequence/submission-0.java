class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int number : nums) {
            int left = 0;
            int right = size;
            // Find first tails[index] >= number
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (tails[middle] < number) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = number;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}