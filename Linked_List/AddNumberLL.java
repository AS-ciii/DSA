package Linked_List;

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        Node n1 = reverseList(num1);
        Node n2 = reverseList(num2);
        
        Node curr = null;
        int carry = 0;
        
        while(n1!=null || n2!=null || carry>0) {
            int a = n1!=null?n1.data : 0;
            int b = n2!=null?n2.data : 0;
            
            int sum = a+b+carry;
            carry = sum/10;
            
            Node temp = new Node(sum%10);
            temp.next = curr;
            curr = temp;
            
            if(n1!=null) n1 = n1.next;
            if(n2!=null) n2 = n2.next;
        }
        while(curr!=null && curr.data == 0) curr = curr.next;
        
        return curr;
    }
    
    static Node reverseList(Node head) {
        Node temp = null;
        while(head!=null) {
            Node temp1 = head.next;
            if(temp==null) {
                temp = head;
                temp.next = null;
            } else {
                head.next = temp;
                temp = head;
            }
            
            head = temp1;
        }
        return temp;
    }
}
