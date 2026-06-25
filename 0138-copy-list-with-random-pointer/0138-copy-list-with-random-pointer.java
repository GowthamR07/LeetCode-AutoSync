/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void CopyandInsertInBetween(Node head){
        Node temp=head;
        while(temp!=null){
        Node CopyNode=new Node(temp.val);
        CopyNode.next=temp.next;
        temp.next=CopyNode;
        temp=temp.next.next;
    }
    }
    public void ConnectRandomPointers(Node head){
        Node temp=head;
        while(temp!=null){
            Node CopyNode=temp.next;
            if(temp.random!=null){
              CopyNode.random=temp.random.next;
            }
            else{
                CopyNode.random=null;
            }
            temp=temp.next.next;
        }
    }
    public Node ConnectNextpointersAndExtractList(Node head){
        Node temp=head;
        Node dummyNode=new Node(-1,null);
        Node res=dummyNode;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            if(temp!=null){
            temp=temp.next;}
        }
        return dummyNode.next;
    }
    public Node copyRandomList(Node head) {
        CopyandInsertInBetween(head);
        ConnectRandomPointers(head);
        return ConnectNextpointersAndExtractList(head);
    }
}