class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
            (x,y)-> y.val-x.val
        );
        Set<Node> visited = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i= a.length-1, j=b.length-1;
        
        /*
        for(int i=0; i<a.length; i++){
            
            for(int j=0; j<b.length; j++){
                
                int t = a[i]+b[j];
                
                if(maxHeap.size() < k){
                    maxHeap.offer(t);
                }else{
                    
                    int top = maxHeap.peek();
                    
                    if(top < t){
                        maxHeap.poll();
                        maxHeap.offer(t);
                    }
                }
            }
        }
        */
        maxHeap.add(new Node(i,j,a[i]+b[j]));
        
        while(k>0){
            
            Node curr = maxHeap.poll();
            
            if(visited.contains(curr)) continue;
            
            res.add(curr.val);
            visited.add(curr);
            
            if(curr.i -1 >=0){
                maxHeap.add(new 
                Node(curr.i-1, curr.j, a[curr.i-1]+b[curr.j]));
            }
            
            if(curr.j-1 >=0){
               maxHeap.add(new 
                Node(curr.i, curr.j-1, a[curr.i]+b[curr.j-1])); 
            }
            
            k--;
            
        }
        
        
        //res.sort((x,y)->y-x);
        
        return res;
        
        
    }
    
    class Node {
        int i, j, val;
        
        public Node(int i, int j, int val){
            this.i=i;
            this.j=j;
            this.val = val;
        }
        
       @Override
       public boolean equals(Object o){
           
           if(this == o) return true;
           
           if(o == null || o.getClass() != getClass()){
               return false;
           }
           
          Node obj = (Node)o;
           
           if(obj.i == this.i && obj.j == this.j && obj.val == this.val)
             return true;
           return false;
       }
       
       @Override
       public int hashCode(){
           return Objects.hash(this.i, this.j, this.val);
       }
    }
}
