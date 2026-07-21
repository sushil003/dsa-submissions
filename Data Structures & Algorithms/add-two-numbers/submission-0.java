/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int carry = 0;
        while (ptr1 != null || ptr2 != null) {
            int first = ptr1 != null ? ptr1.val : 0;
            int second = ptr2 != null ? ptr2.val : 0;
            int sum = carry + first + second;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            if (ptr1 != null) {
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                ptr2 = ptr2.next;
            }
            result = result.next;
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return dummy.next;
    }
}