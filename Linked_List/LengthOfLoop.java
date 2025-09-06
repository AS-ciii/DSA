/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head, fast = head;
        boolean found = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                found = true;
                break;
            }
        }

        if (!found) return 0;

        int res = 1;
        Node temp = slow.next;
        while (temp != slow) {
            res++;
            temp = temp.next;
        }
        return res;
    }
}
