class Solution {
    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() == 0)
            return -1;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        queue.offer("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (!set.add(curr))
                    continue;
                if (curr.equals(target))
                    return level;
                for (String nextLock : getNextStates(curr)) {
                    if (!set.contains(nextLock))
                        queue.offer(nextLock);
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}