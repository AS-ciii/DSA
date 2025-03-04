package Linked_List;

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node num = new Node(-1);
        Node curr = num;
        
        while(head1!=null && head2!=null) {
            if(head1.data<=head2.data) {
                curr.next = head1;
                head1 = head1.next;
            }
            else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        if(head1!=null) curr.next = head1;
        else curr.next = head2;
        
        return num.next;
    }
}
