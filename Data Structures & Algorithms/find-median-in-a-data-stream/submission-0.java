class MedianFinder {
    // Smaller half (max heap) and larger half (min heap)
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void addNum(int num) {
        // Maintain ordering between both halves
        lower.offer(num);
        upper.offer(lower.poll());

        // Lower may contain at most one extra element
        if (upper.size() > lower.size())
            lower.offer(upper.poll());
    }

    public double findMedian() {
        // Odd: top of lower. Even: average both tops
        return lower.size() > upper.size()
                ? lower.peek()
                : ((long) lower.peek() + upper.peek()) / 2.0;
    }
}
/**
addNum():     O(log n)
findMedian(): O(1)
Space:        O(n)
 */