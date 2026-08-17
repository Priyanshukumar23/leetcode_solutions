
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to simplify head operations
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Count total nodes
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // prev should point to the node BEFORE the current group (start with dummy)
        ListNode prev = dummy;

        // While we have at least k nodes remaining
        while (count >= k) {
            // tail is the first node of the group; after reversal it becomes the tail
            ListNode tail = prev.next;
            ListNode nxt = tail.next;

            // Insert each of the next (k-1) nodes to the front of the group
            for (int i = 1; i < k; i++) {
                tail.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = tail.next;
            }

            // Move prev to the tail (which is the end of the reversed group)
            prev = tail;
            count -= k;
        }

        return dummy.next;
    }
}