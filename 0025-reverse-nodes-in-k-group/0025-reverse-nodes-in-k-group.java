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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {
            // Check if there are at least k nodes remaining
            ListNode kthNode = getKthNode(prevGroup, k);
            if (kthNode == null) break;

            ListNode nextGroup = kthNode.next;
            ListNode prev = kthNode.next;
            ListNode curr = prevGroup.next;

            // Reverse the k nodes
            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Connect the reversed group with the previous group
            ListNode tmp = prevGroup.next;
            prevGroup.next = kthNode;
            prevGroup = tmp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}