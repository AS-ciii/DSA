package Heap;


class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0; i<k; i++) heap.add(arr[i]);
        
        for(int i=k; i<arr.length; i++) {
            if(arr[i] > heap.peek()) {
                heap.poll();
                heap.add(arr[i]);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        
        return res;
    }
}
