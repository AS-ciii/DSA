class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        SegmentTree tree = new SegmentTree(prefix);
        int ans =  Integer.MIN_VALUE;
        for(int i = 0 ; i <= arr.length-a ; i++){
            int f = i + (a-1);
            int s = i + (b-1) < arr.length ? i + (b-1):arr.length - 1;
            int m = tree.query(f,s);
            if(i == 0){
                ans = Math.max(ans,m);
            }else{
                ans = Math.max(ans,m - prefix[i-1]);
            }
        }
        return ans;
    }
}
class SegmentTree{
    class Node{
        int max;
        int l;
        int r;
        Node left;
        Node right;
        Node(int l ,int r){
            this.l = l;
            this.r = r;
        }
    }
    Node root;
    SegmentTree(int[] arr){
        root = createNode(arr,0,arr.length-1);
    }
    public Node createNode(int[] arr,int st,int ed){
        if(st == ed){
            Node node = new Node(st,ed);
            node.max=arr[st];
            return node;
        }
        int mid = st + (ed-st)/2;
        Node node = new Node(st,ed);
        node.left = createNode(arr,st,mid);
        node.right = createNode(arr,mid+1,ed);
        node.max = Math.max(node.left.max,node.right.max);
        return node;
    }
    public int query(int s,int e){
        return doquery(root,s,e);
    }
    public int doquery(Node node,int s,int e){
        if(node.l >= s && node.r <= e){
            return node.max;
        }else if(node.l > e || node.r <s){
            return Integer.MIN_VALUE;
        }
        int l = doquery(node.left,s,e);
        int r = doquery(node.right,s,e);
        return Math.max(l,r);
    }
}
