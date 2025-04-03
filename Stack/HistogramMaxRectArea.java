package Stack;

class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        
        Stack<Integer> s = new Stack<>();
        int maxArea = 0; 
        
        for(int i=0; i<=n; i++) {
            while(!s.isEmpty() && (i==n || arr[s.peek()]>=arr[i])) {
                int h = arr[s.pop()];
                int w = s.isEmpty()?i:i-s.peek()-1;
                
                maxArea = Math.max(maxArea, h*w);
            }
            s.push(i);
        }
        
        return maxArea;
    }
}
