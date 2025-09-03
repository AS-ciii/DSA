/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node prev = null;
        Node forw; Node curr = head;
        while(curr != null){
            forw = curr.next;
            curr.next = prev; if(prev != null)
            prev.prev = curr.next;
            prev = curr;
            curr = forw;
        }
        curr = prev;
        while(curr.next != null){
            curr = curr.next;
        }
        return prev;
    }
}
