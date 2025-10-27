class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n == 0 || m == 0 || k == 0) return result;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]));
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];

            result.add(new ArrayList<>(Arrays.asList(arr1[i], arr2[j])));
            
            if (j + 1 < m) {
                pq.offer(new int[]{i, j + 1});
            }
        }
        
        
        return result;
    }
}
