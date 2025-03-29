package Heap;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );
        
        for(int[] point : points) {
            heap.offer(point);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++) {
            res[i] = heap.poll();
        }
        
        return res;
    }
    
    private int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}