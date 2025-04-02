package Stack;

class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            
            if(stack.isEmpty()) res.add(-1);
            else res.add(stack.peek());
            
            stack.push(arr[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=res.size()-1; i>=0; i--) result.add(res.get(i));
        
        return result;
    }
}
