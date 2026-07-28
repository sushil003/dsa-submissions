class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
