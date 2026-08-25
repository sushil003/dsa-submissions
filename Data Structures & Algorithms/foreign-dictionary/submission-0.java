class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        // Add every unique character
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        // Compare adjacent words to build ordering rules
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            // Invalid: longer word appears before its prefix
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                char from = first.charAt(j);
                char to = second.charAt(j);
                if (from != to) {
                    // Avoid adding the same edge twice
                    if (graph.get(from).add(to)) {
                        indegree.put(to, indegree.get(to) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // Not all characters processed means there is a cycle
        return result.length() == indegree.size() ? result.toString() : "";
    }
}