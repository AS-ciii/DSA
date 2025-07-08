class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Pair[] modArr = new Pair[n];
        for(int i=0;i<n;i++){
            modArr[i] = new Pair(arr[i],map.get(arr[i]));
        }
        Stack<Pair> st = new Stack<>();
        int idx = n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] temp = new int[n];
        while(idx >= 0){
            Pair curr = modArr[idx];
            while(!st.isEmpty() && curr.freq >= st.peek().freq){
                st.pop();
            }
            temp[idx] = st.isEmpty() ? -1 : st.peek().elem;
            st.push(curr);
            idx--;
        }
        for(int i=0;i<n;i++){
            ans.add(temp[i]);
        }
        return ans;
    }
}

class Pair{
    int elem;
    int freq;
    public Pair(int elem,int freq){
        this.elem = elem;
        this.freq = freq;
    }
}
