class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) {
                queue.offer(l);
            }
        }
        while (!queue.isEmpty()) {
            ListNode c = queue.poll();
            curr.next = c;
            curr = curr.next;
            ListNode next = c.next;
            if (next != null) {
                queue.offer(next);
            }
        }
        return dummy.next;
    }
}