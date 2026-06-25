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
    public ListNode merge2LL(ListNode list1,ListNode list2){
        ListNode dummyNode=new ListNode(-1,null);
        ListNode res=dummyNode;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                res.next=list1;
                res=list1;
                list1=list1.next;
            }
            else{
                res.next=list2;
                res=list2;
                list2=list2.next;
            }
        }
        if(list1!=null){
            res.next=list1;
        }
        if(list2!=null){
            res.next=list2;
        }
        return dummyNode.next;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode middle=findMiddle(head);
        ListNode leftHead=head;
        ListNode rightHead=middle.next;
        middle.next=null;
        leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);
        return merge2LL(leftHead,rightHead);
    }
}