class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4)
            return false;

        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;

        int target = sum / 4;
        Arrays.sort(matchsticks);

        if (matchsticks[matchsticks.length - 1] > target) {
            return false;
        }

        return dfs(matchsticks, matchsticks.length - 1, new int[4], target);
    }

    private boolean dfs(int[] sticks, int index, int[] sides, int target) {
        if (index < 0)
            return true;
            
        for (int side = 0; side < 4; side++) {
            if (sides[side] + sticks[index] > target) {
                continue;
            }

            sides[side] += sticks[index];

            if (dfs(sticks, index - 1, sides, target)) {
                return true;
            }

            sides[side] -= sticks[index];

            // Trying another empty side would be identical
            if (sides[side] == 0)
                break;
        }

        return false;
    }
}