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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        if(head==null || head.next==null)return head;
        int f = 0;
        int l = 0;
        int c=0;
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        int st = c-k;
        ListNode cur = head;
        for(int i=0;i<k-1;i++){
            cur = cur.next;
        }
        f = cur.val;
        ListNode fast = head;
        for(int i=0;i<st;i++){
            fast = fast.next;
        }
        l = fast.val;
        ListNode real = head;
        for(int i=0;i<c;i++){
            if(i==k-1){
                real.val = l;
            }
            if(i==st){
                real.val = f;
            }
            real = real.next;
        }
        return head;
    }
}