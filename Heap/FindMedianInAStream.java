package Heap;

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        
        for(int num : arr) {
            if(lower.isEmpty() || num<=lower.peek()) lower.add(num);
            else higher.add(num);
            
            if(lower.size()>higher.size()+1) higher.add(lower.poll());
            else if(higher.size()>lower.size()) lower.add(higher.poll());
            
            if(lower.size()>higher.size()) medians.add((double)lower.peek());
            else medians.add((lower.peek()+higher.peek())/2.0);
        }
        return medians;
    }
}
