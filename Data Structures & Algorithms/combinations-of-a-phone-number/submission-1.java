class Solution {
    public static String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }
        combinations("", digits, 0, res);
        return res;
    }

    private void combinations(String prefix, String digits, int offset, List<String> res) {
        if (offset == digits.length()) {
            res.add(prefix);
            return;
        }
        String LETTERS = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < LETTERS.length(); i++) {
            combinations(prefix + LETTERS.charAt(i), digits, offset + 1, res);
        }
    }
}