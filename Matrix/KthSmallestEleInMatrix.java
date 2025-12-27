class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(mat[i][j]);
            }
        }
        for(int i=1;i<k;i++)
            pq.poll();
        return pq.peek();
    }
}
