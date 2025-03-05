package Linked_List;

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if(head==null) return head;
        
        Node curr = head;
        Node newHead = null;
        Node tail = null;
        
        while(curr!=null) {
            Node grpHead = curr;
            Node prev = null;
            Node next = null;
            int cnt = 0;
            
            while(curr!=null && cnt<k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }
            
            if(newHead==null) newHead=prev;
            if(tail!=null) tail.next = prev;
            
            tail = grpHead;
        }
        
        return newHead;
    }
}
