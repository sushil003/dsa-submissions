class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        return dfs(nums, nums.length - 1, new int[k], sum);
    }

    private boolean dfs(int[] nums, int i, int[] buckets, int target) {
        if (i == -1) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            if (nums[i] + buckets[j] <= target) {
                buckets[j] += nums[i];
                if (dfs(nums, i - 1, buckets, target)) {
                    return true;
                }
                buckets[j] -= nums[i];
            }
            if (buckets[j] == 0) {
                break;
            }
        }
        return false;
    }
}