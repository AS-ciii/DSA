/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    class Pair{
        int col;
        Node node;
        Pair(Node node,int col){
            this.node=node;
            this.col=col;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int col=temp.col;
            Node node=temp.node;
            
            if(!mp.containsKey(col)){
                mp.put(col,new ArrayList<>());
            }
            mp.get(col).add(node.data);
            
            if(node.left!=null) q.add(new Pair(node.left,col-1));
            if(node.right!=null) q.add(new Pair(node.right,col+1));
        }
        
        for(ArrayList<Integer> l:mp.values()){
            res.add(l);
        }
        
        return res;
    }
}
