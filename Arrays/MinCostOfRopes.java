class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr){
            pq.add(x);
        }
        int sum =0;
        int cost = 0;
        while(pq.size() >1){
            int fst = pq.poll();
            int sec = pq.poll();
            cost += (fst+sec);
            sum = fst+sec;
            pq.add(sum);
        }
        return cost;
    }
}
