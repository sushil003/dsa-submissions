class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, result, root);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, result, root);
        }
        if (j > 0) {
            dfs(board, i, j - 1, result, root);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, result, root);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new TrieNode();
                }
                curr = curr.next[i];
            }
            curr.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}