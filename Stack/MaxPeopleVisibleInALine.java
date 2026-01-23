class Solution {
    int[] prevGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek(); 
            st.push(i);
        }
        return ans;
    }

    int[] nextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? arr.length : st.peek(); 
            st.push(i);
        }
        return ans;
    }

    public int maxPeople(int[] arr) {
        int[] prev = prevGreater(arr);
        int[] next = nextGreater(arr);

        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            int tot = next[i] - prev[i] - 1; 
            ans = Math.max(ans, tot);
        }
        return ans;
    }
}
