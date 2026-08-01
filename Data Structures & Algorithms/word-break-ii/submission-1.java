class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // Acting as memo
        Map<Integer, List<String>> map = new HashMap<>();
        return wordBreak(s, set, map, 0);
    }

    private List<String> wordBreak(
        String s, Set<String> set, Map<Integer, List<String>> map, int start) {
        List<String> l = new LinkedList<>();
        if (start == s.length()) {
            l.add("");
            return l;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, set, map, end);
                for (String l1 : list) {
                    l.add(s.substring(start, end) + (l1.equals("") ? "" : " ") + l1);
                }
            }
        }
        map.put(start, l);
        return l;
    }
}