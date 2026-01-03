/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node node) {
        // code here
        if(node==null||node.next==null)
        return node;
        Node temp=node;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        //merge the last node and bottom of previous node
       Node mergedList=  mergeList(temp.bottom,temp.next);
       
       temp.bottom=mergedList;
       temp.next=null;
       return flatten(node);
        
    }
    public Node mergeList(Node head1,Node head2)
    {
        if(head1==null)
        return head2;
        if(head2==null)
        return head1;
        
        Node dummy=new Node(-1);
        Node curr=dummy;
        Node ptr1=head1;
        Node ptr2=head2;
        while(ptr1!=null&&ptr2!=null)
        {
            if(ptr1.data<ptr2.data)
            {
               
               curr.bottom=ptr1;
               ptr1=ptr1.bottom;
              
               
            }
            else{
                curr.bottom=ptr2;
               ptr2=ptr2.bottom;
            }
            curr=curr.bottom;
        }
        if(ptr1!=null)
        {
            curr.bottom=ptr1;
        }
        else
        {
            curr.bottom=ptr2;
        }
        
        return dummy.bottom;
        
    }
}
