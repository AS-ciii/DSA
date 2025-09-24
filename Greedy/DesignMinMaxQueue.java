class SpecialQueue {

    private Queue<Integer> queue;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;

    public SpecialQueue() {
        queue = new LinkedList<>();
        minDeque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public void enqueue(int x) {
        queue.offer(x);

       
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offer(x);

      
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offer(x);
    }

    public void dequeue() {
        int removed = queue.poll();
        if (removed == minDeque.peek()) {
            minDeque.poll();
        }
        if (removed == maxDeque.peek()) {
            maxDeque.poll();
        }
    }

    public int getFront() {
        return queue.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }

    public int getMax() {
        return maxDeque.peek();
    }
}
