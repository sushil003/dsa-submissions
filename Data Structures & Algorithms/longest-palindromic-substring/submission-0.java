class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i); // odd
            String s2 = extend(s, i, i + 1); // even
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }
    private String extend(String s, int l, int r) {
        for (; 0 <= l && r < s.length(); l--, r++) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
        }
        return s.substring(l + 1, r);
    }
}