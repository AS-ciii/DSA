class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int last = Integer.MIN_VALUE;
        for(int ele : arr){
            while(!st.isEmpty() && st.peek() < ele){
                last = st.pop();
            }
            if(last > ele)
                return false;
            st.push(ele);
        }
        return true;
    }
}
