class Solution {
     // Helper: counts BSTs possible with 'n' nodes
    public int countWays(int n) {
        if(n==0 || n==1) return 1;
        int total = 0;
        for(int root=1; root<=n; root++) {
            int left = countWays(root-1);
            int right = countWays(n-root);
            total += left * right;
        }
        return total;
    }
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            // For arr[i] as root:
            int leftCount = 0;
            int rightCount = 0;
            for(int j=0; j<n; j++) {
                if(arr[j] < arr[i]) leftCount++; // elements smaller than arr[i]
                if(arr[j] > arr[i]) rightCount++; // elements larger than arr[i]
            }
            // BSTs = ways to arrange left × ways to arrange right
            result.add(countWays(leftCount) * countWays(rightCount));
        }
        return result;
    }
}
