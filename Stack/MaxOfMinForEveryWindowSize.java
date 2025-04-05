package Stack;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        
        int[] maxOfMin = new int[n+1];
        
        for(int i=0; i<n; i++) {
            int ws = right[i]-left[i]-1;
            maxOfMin[ws] = Math.max(maxOfMin[ws], arr[i]);
        }
        
        for(int i=n-1; i>=1; i--) maxOfMin[i] = Math.max(maxOfMin[i], maxOfMin[i+1]);
        
        for(int i=1; i<=n; i++) res.set(i-1, maxOfMin[i]);
        
        return res;
    }
}