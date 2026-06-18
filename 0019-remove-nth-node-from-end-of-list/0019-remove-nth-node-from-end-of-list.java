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
       ListNode dummyNode=new ListNode(0,head);
       ListNode fast=dummyNode;
       ListNode slow=dummyNode;
       // move the fast node till it crosses N
       for(int i=0;i<n;i++){
        fast=fast.next;
       }
       while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
       }
       slow.next=slow.next.next;
       return dummyNode.next;
        
    }
}