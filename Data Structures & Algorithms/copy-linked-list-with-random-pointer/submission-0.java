class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node dummy = new Node(-1);
        Node clone = dummy;
        curr = head;
        while (curr != null) {
            Node next = curr.next.next;
            clone.next = curr.next;
            clone = curr.next;
            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }
}