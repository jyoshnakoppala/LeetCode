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
        if(head==null)
        return null;
        
        ListNode cur=head;
        int count=0; 
        while(cur!=null)
        {
            count++;
            cur=cur.next;
        }
        ListNode temp=head;
        int count1=count-n;
        if(count1==0) return head.next;
        int t=0;
        while(t<count1-1)
        {
            temp=temp.next;
            t++;
        }
        temp.next=temp.next.next;
        return head;
    }
}