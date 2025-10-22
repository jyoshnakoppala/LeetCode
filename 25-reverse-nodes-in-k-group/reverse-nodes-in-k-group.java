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
        ListNode temp=head;
        ListNode newhead=head;
        ListNode prev=null;

        while(temp!=null)
        {
            ListNode knode=getknode(temp, k);
            if(knode==null)
            {
                if(prev!=null) prev.next=temp;
                break;
            }
            ListNode next=knode.next;
            knode.next=null;

            ListNode reversed=Reverse(temp);

            if(temp==head) newhead=reversed;
            else
            {
                prev.next=reversed;
            }
            prev=temp;
            temp=next;
        }
        return newhead;
    }
    private ListNode getknode(ListNode temp, int k)
    {
        k--;
        while(temp!=null && k>0)
        {
            temp=temp.next;
            k--;
        }
        return temp;
    }
    private ListNode Reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}