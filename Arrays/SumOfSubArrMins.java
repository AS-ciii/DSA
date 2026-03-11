class Solution {
    
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        
        int[] nse = new int[n];
        int[] pse = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        
        Arrays.fill(nse, n);
        
        for(int i = n - 2; i >= 0; i--) {
            int num = arr[i];
            
            while(!stack.isEmpty() && arr[stack.peek()] > num) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        stack = new Stack<>();
        stack.push(0);
        Arrays.fill(pse, -1);
        
        for(int i = 1; i < n; i++) {
            int num = arr[i];
            
            while(!stack.isEmpty() && arr[stack.peek()] >= num) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += arr[i] * (nse[i] - i) * (i - pse[i]);
        }
        
        return sum;
        
    }
}
