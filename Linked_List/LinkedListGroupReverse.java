/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (head != null) {
            
            Node tail = prev;
            int count = 0;
            while (count < k && tail.next != null) {
                tail = tail.next;
                count++;
            }

            if (count == 0) break; // no nodes left

            Node nextGroup = tail.next;

            
            Node curr = head;
            Node prevNode = nextGroup;
            while (curr != nextGroup) {
                Node temp = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = temp;
            }

           
            Node newHead = prev.next;
            prev.next = tail;
            prev = newHead;
            head = nextGroup;
        }

        return dummy.next;
    }

    
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
