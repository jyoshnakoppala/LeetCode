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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        return;

        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;

        ListNode cur=mid.next;
        mid.next=null;
        ListNode prev=null;
        while(cur!=null)
        {
            ListNode front=cur.next;
            cur.next=prev;
            prev=cur;
            cur=front;
        }

        ListNode first=head;
        ListNode second=prev;

        while(second!=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            first.next=second;
            second.next=temp1;

            second=temp2;
            first=temp1;
        }
    }
}