class WordDictionary {
    class TrieNode {
        TrieNode[] links;
        boolean isEnd;
        TrieNode() {
            links = new TrieNode[27];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode n = root;
        for (Character tempC : word.toCharArray()) {
            if (n.links[tempC - 'a'] == null) {
                n.links[tempC - 'a'] = new TrieNode();
            }
            n = n.links[tempC - 'a'];
        }
        n.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, TrieNode currNode, int pointer) {
        if (currNode == null) {
            return false;
        }
        for (int i = pointer; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : currNode.links)
                    if (search(word, child, i + 1))
                        return true;
                return false;
            } else {
                if (currNode.links[ch - 'a'] != null)
                    currNode = currNode.links[ch - 'a'];
                else
                    return false;
            }
        }
        return currNode.isEnd;
    }
}