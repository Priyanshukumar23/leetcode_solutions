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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode temp = head;
        if(head==null || head.next==null)return null;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        int st = c-n;
        ListNode curr = head;
        for(int i=0;i<st-1;i++){
            curr = curr.next;
        }
        if(n==c)return head.next;
        if(curr.next.next!=null){

        curr.next = curr.next.next;
        } else{
            curr.next = null;
        }
        return head;

    }
}