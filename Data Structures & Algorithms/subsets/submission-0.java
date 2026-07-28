class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}