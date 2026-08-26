class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
                          // ODD           EVEN
            result += search(s, i, i) + search(s, i, i + 1);
        }
        return result;
    }

    private int search(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left--) == s.charAt(right++)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}