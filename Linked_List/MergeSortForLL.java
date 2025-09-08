/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
         if (head == null || head.next == null) {
            return head;
        }
        
        
        Node mid = getMiddle(head);
        Node rightHalf = mid.next;
        mid.next = null;  // break the list
        
        
        Node left = mergeSort(head);
        Node right = mergeSort(rightHalf);
        
        
        return merge(left, right);
    }
    
   
    private static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
       
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        
        return dummy.next;
    }
    
    
    private static Node getMiddle(Node head) {
        Node slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow; 
    }
}
