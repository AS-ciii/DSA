class Solution {
    static int maxArea(int mat[][]) {
        // code here
        for(int j = 0 ; j < mat[0].length ; j++){
            
            for(int i = 1 ; i < mat.length ; i++){

                if(mat[i][j] != 0){
                    mat[i][j] += mat[i-1][j];
                }
            }
        }
        
        int maxArea = 0;
        for(int i = 0 ; i < mat.length ; i++){
            maxArea = Math.max(maxArea, CurrMax(mat[i]));
        }
        
        return maxArea;
    }
    
    static int CurrMax(int[] arr){
        
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st1 = new Stack<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            while(st1.size() > 0 && arr[i] <= arr[st1.peek()]){
                st1.pop();
            }
            if(st1.size() == 0){
                nse[i] = n;
            }
            else{
                nse[i] = st1.peek();
            }
            st1.push(i);
        }
        
        int[] pse = new int[n];
        Stack<Integer> st2 = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            while(st2.size() > 0 && arr[i] <= arr[st2.peek()]){
                st2.pop();
            }
            if(st2.size() == 0){
                pse[i] = -1;
            }
            else{
                pse[i] = st2.peek();
            }
            st2.push(i);
        }
        
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int width = nse[i] - pse[i] - 1;
            int area = arr[i] * width;
            max = Math.max(area, max);
        }
        
        return max;
        
    }
}
