package Linked_List;

class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
