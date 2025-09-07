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
    Node mergeKLists(Node[] arr) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            Node curr = arr[i];
            while(curr !=null){
                al.add(curr.data);
                curr = curr.next;
            }
        }
        Collections.sort(al);
        Node head = new Node(al.get(0)) ;
        Node curr = head;
        for(int i=1; i<al.size(); i++){
            Node temp =  new Node(al.get(i));
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}
