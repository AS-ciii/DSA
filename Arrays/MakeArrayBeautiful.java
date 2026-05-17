class Solution {
    public ArrayList<Integer> makeBeautiful(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        
        for (int x : arr) {
            if (!stack.isEmpty() && 
               ((stack.get(stack.size() - 1) < 0 && x >= 0) || 
                (stack.get(stack.size() - 1) >= 0 && x < 0))) {
                
                stack.remove(stack.size() - 1); // remove opposite sign pair
            } else {
                stack.add(x);
            }
        }
        
        return stack;
    }
}

