package Linked_List;

class Solution {
    public Node rotate(Node head, int k) {
        if(head==null || head.next==null|| k==0) return head;
        
        Node temp = head;
        
        int len = 1;
        
        while(temp.next!=null) {
            temp = temp.next;
            len++;
        }
        
        k=k%len;
        if(k==0) return head;
        
        Node curr = head;
        for(int i=1; i<k; i++) curr = curr.next;
        
        Node nextHead = curr.next;
        curr.next = null;
        temp.next = head;
        
        return nextHead;
    }
}
