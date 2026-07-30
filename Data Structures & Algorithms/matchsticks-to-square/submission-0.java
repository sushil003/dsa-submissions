class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int perimeter = 0;
        for (int ele : nums) perimeter += ele;
        if (perimeter % 4 != 0)
            return false;
        Arrays.sort(nums);
        int side = perimeter / 4;
        return makesquareSub(nums, nums.length - 1, new int[] {side, side, side, side});
    }

    private boolean makesquareSub(int[] nums, int i, int[] s) {
        if (i < 0)
            return s[0] == 0 && s[1] == 0 && s[2] == 0 && s[3] == 0;
        for (int j = 0; j < s.length; j++) {
            if (nums[i] > s[j])
                continue;
            s[j] -= nums[i];
            if (makesquareSub(nums, i - 1, s))
                return true;
            s[j] += nums[i];
        }
        return false;
    }
}