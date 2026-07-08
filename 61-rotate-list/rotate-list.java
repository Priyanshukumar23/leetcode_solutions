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
        ListNode temp = head;
        int c = 1;
        if(head==null)return null;
        if(k==0)return head;
        while(temp.next!=null){
            c++;
            temp = temp.next;
        }
        temp.next = head;
        k = k%c;
        int st = c-k;
        ListNode cur = head;
        for(int i=0;i<st;i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}