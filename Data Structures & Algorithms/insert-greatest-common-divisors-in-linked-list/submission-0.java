class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = new ListNode(gcd(current.val, next.val), next);
            // Move to the next original node
            current = next;
        }
        return head;
    }

    private int gcd(int first, int second) {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }
}