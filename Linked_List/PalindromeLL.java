/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        Node prev = null;
        Node curr = head;
        Node head1 = null;
        Node temp = null;
        while(curr!=null && curr.next!=null)
        {
            if(prev==null){
                prev=head;
            }else{
                head1 = prev;
                prev = prev.next;
                head1.next = temp;
                temp = head1;
            }
            curr = curr.next.next;
        }
        if(prev!=null){
            head1 = prev;
            if(curr==null)
                prev = prev.next;
            else
                prev = prev.next.next;
            
             
            head1.next = temp;
            while(prev!=null)
            {
                if(head1.data!=prev.data)
                return false;
                
                head1 = head1.next;
                prev = prev.next;
            }
        }
        
        return true;
    }
}
