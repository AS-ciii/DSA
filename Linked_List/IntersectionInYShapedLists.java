/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if(head1 == null || head2== null) return null;
        Node a = head1;
        Node b=head2;
        while(a!=b) {
            if(a==null) {
                a=head2;
            } else {
                a=a.next;
            }
            if(b==null){
                b=head1;
            } else {
                b=b.next;
            }
        }
        return a;
    }
}
