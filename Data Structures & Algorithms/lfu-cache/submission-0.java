class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> frequencyMap = new HashMap<>();

    private static class Node {
        int value;
        int frequency = 1;

        Node(int value) {
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateFrequency(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            updateFrequency(key, node);
            return;
        }
        if (cache.size() == capacity) {
            LinkedHashSet<Integer> keys = frequencyMap.get(minFrequency);
            int keyToRemove = keys.iterator().next();
            keys.remove(keyToRemove);
            cache.remove(keyToRemove);
            if (keys.isEmpty()) {
                frequencyMap.remove(minFrequency);
            }
        }
        cache.put(key, new Node(value));
        frequencyMap.computeIfAbsent(1, ignored -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    private void updateFrequency(int key, Node node) {
        int oldFrequency = node.frequency;
        LinkedHashSet<Integer> keys = frequencyMap.get(oldFrequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            frequencyMap.remove(oldFrequency);
            if (minFrequency == oldFrequency) {
                minFrequency++;
            }
        }
        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, ignored -> new LinkedHashSet<>()).add(key);
    }
}