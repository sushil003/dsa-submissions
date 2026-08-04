class Solution {
    int[] mappings = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        // Store each character's position in the alien alphabet
        for (int i = 0; i < order.length(); i++) mappings[order.charAt(i) - 'a'] = i;
        // Check every adjacent pair
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]))
                return false;
        }
        return true;
    }

    // Returns true when s1 should come after s2 (incorrect order)
    private boolean compare(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n && i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return mappings[s1.charAt(i) - 'a'] > mappings[s2.charAt(i) - 'a'];
            }
        }
        // If all compared characters match, longer word must come later
        return n > m;
    }
}