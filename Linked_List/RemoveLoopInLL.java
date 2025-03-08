package Linked_List;

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        
        while(temp!=null) {
            if(set.contains(temp.next)) {
                temp.next = null;
                break;
            }
            
            set.add(temp);
            temp = temp.next;
        }
    }
}