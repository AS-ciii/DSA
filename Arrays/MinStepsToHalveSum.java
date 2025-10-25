class Solution {
    public int minOperations(int[] arr) {
       PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int num : arr) {
            pq.offer((double) num);
            sum += num;
        }

        double target = sum / 2;
        double currSum = sum;
        int ops = 0;

        while (currSum > target) {
            double max = pq.poll();      
            double half = max / 2.0;     
            currSum -= (max - half);     
            pq.offer(half);               
            ops++;
        }

        return ops;
    }
}
