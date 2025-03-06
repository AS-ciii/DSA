package Linked_List;

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(slow!=null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast) return true;
        }
        return false;
    }
}
