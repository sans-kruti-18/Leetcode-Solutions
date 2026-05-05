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

   public ListNode findKnode(ListNode temp,int k)
   {
       k-=1;
       while(temp!=null && k>0)
       {
        temp=temp.next;
        k--;
       }

       return temp;

   }

    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null || k==0)
         return head;

        ListNode tail=head;
        int len=1;

        while(tail.next!=null)
        {
            len++;
            tail=tail.next;
        }

       

        if(k%len == 0)
         return head;

        tail.next=head;
        k=k%len;

        ListNode kthNode = findKnode(head,len-k);
        head=kthNode.next;
        kthNode.next=null;

        return head;

        
    }
}