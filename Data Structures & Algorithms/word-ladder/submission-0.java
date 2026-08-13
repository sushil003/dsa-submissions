class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        int level = 0;
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    return level + 1;
                }
                char[] ch = curr.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String nextWord = String.valueOf(ch);
                        if (!visited.contains(nextWord) && set.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    ch[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}