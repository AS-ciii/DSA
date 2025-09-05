/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        if (head == null || head.next == null) return head;

        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;

        
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        
        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

   
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
