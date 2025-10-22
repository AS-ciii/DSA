class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;

        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            pq.add(arr[i]); 
        }

        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll(); 
            pq.add(arr[i]);           
        }

        
        while (!pq.isEmpty()) {        
            arr[index++] = pq.poll();
        }
        
    }
}
