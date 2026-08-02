class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        void add(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null)
                    node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.isWord = true;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        // Add all dictionary words to Trie
        for (String word : dictionary) root.add(word);
        int n = s.length();
        int[] dp = new int[n + 1];
        // dp[i] = minimum extra characters from index i to end
        for (int i = n - 1; i >= 0; i--) {
            // Consider s[i] as an extra character
            dp[i] = 1 + dp[i + 1];
            TrieNode node = root;
            // Find dictionary words starting at index i
            for (int j = i; j < n; j++) {
                node = node.children[s.charAt(j) - 'a'];
                if (node == null)
                    break;
                // s[i...j] is a dictionary word
                if (node.isWord)
                    dp[i] = Math.min(dp[i], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
/*
Time: O(D + n²)
Space: O(D + n)

D = total number of characters in dictionary
n = length of s
*/