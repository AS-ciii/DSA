class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        
        int i = 0;
        while(i < n) {
            if(st.isEmpty() || sameSign(st.peek(), arr[i])) {
                st.push(arr[i]);
            }
            else pushEle(arr[i], st);
            i++;
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!st.isEmpty()) res.add(st.pop());
        Collections.reverse(res);
        return res;
    }
    
    boolean sameSign(int a, int b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }
    
    void pushEle(int ele, Stack<Integer> st) {
        
        while(!st.isEmpty() && !sameSign(st.peek(), ele)) {
            int peek = st.pop();
            if (Math.abs(peek) == Math.abs(ele)) return;
            else if (Math.abs(peek) > Math.abs(ele)) {
                ele = peek;
            }
        }
        st.push(ele);
    }
}
