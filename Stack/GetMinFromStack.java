package Stack;

class Solution {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()) minStack.push(x);
    }

    // Remove the top element from the Stack
    public void pop() {
        if(!stack.isEmpty()) {
            int rem = stack.pop();
            if(rem == minStack.peek()) minStack.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        return stack.isEmpty()?-1:stack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        return minStack.isEmpty()?-1:minStack.peek();
    }
}
