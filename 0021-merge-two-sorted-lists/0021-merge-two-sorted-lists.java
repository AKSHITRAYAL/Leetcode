/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Handle edge cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Ensure l1 starts with smaller value
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode head = l1;

        while (l1 != null && l2 != null) {
            ListNode prev = null;

            // Move l1 while it's smaller
            while (l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            }

            // Link l2 here
            prev.next = l2;

            // Swap l1 and l2
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        return head;
    }
}