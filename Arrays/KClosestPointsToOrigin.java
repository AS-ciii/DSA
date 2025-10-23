class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
      
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new int[]{distance, i});
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int idx = curr[1];
            ArrayList<Integer> point = new ArrayList<>();
            point.add(points[idx][0]);
            point.add(points[idx][1]);
            res.add(point);
            k--;
        }
        return res;
    }
}
