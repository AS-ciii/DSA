class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        int n = color.length;
        Stack<Integer> col = new Stack<>();
        Stack<Integer> rad = new Stack<>();
   
        for(int i=0; i<n; i++){
            int c = color[i];
            int r = radius[i];
            if(col.isEmpty()){
                col.push(c);
                rad.push(r);
                continue;
            }
            if(col.peek() == c && rad.peek() == r){
                col.pop();
                rad.pop();
            }
            else{
                col.push(c);
                rad.push(r);
            }
        }
        
        return col.size();
    }
}
