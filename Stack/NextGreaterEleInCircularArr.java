class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] sol = new int[n];
        
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            sol[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        for (int i = 0; i < n; i++) {
            list.add(sol[i]);
        }
        
        return list;
    }
}
