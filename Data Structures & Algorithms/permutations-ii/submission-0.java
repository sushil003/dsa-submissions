class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tempList,int[] nums,boolean[] used) {
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i-1] == nums[i] && !used[i-1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backTrack(res,tempList,nums,used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
        }
    }
}