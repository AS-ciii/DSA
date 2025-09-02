class Solution {
    public Node swapKth(Node head, int k) {
        // code here
        // ArrayList<Integer> ob=new ArrayList<Integer>();
        Node ptr=head;
        int c=0;
        while(ptr!=null){
            c++;
            // ob.add(ptr.data)
            ptr=ptr.next;
        }
        if(k>c)
        return head;
        int i=0;
        ptr=head;
        for( i=0;i<k-1;i++){
            ptr=ptr.next;
        }
        Node link=ptr;
        int temp=ptr.data;
        ptr=head;
        for(i=0;i<c-k;i++){
            ptr=ptr.next;
        }
        link.data=ptr.data;
        ptr.data=temp;
        return head;
    }
}
