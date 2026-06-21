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
    public ListNode reverseLL(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public ListNode getKthNode(ListNode head,int k){
        k-=1;
        ListNode curr=head;
        while(curr!=null&&k>0){
            k--;
            curr=curr.next;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextNode;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode KthNode=getKthNode(temp,k);
            if(KthNode==null){
                if(prevNode!=null) prevNode.next=temp;
                break;
            }
            nextNode=KthNode.next;
            KthNode.next=null;
            reverseLL(temp);
            if(temp==head){
                head=KthNode;
            }
            else{
                prevNode.next=KthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}