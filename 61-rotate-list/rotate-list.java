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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
        ListNode temp = head;

        int c = 1;
        while(temp.next!=null){
            temp = temp.next;
            c++;
        }
        temp.next = head;
        k = k%c;
        int s = c-k;
        for(int i=1;i<s;i++){
            head = head.next;
        }
        ListNode newt = head.next;
        head.next = null;
        return newt;
    }
}