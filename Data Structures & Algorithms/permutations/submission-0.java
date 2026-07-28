class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}