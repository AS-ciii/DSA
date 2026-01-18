class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        HashMap<Integer , Integer>map = new HashMap<>();
        ArrayList<Integer>result = new ArrayList<>();
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int i=arr.length-1;
        while(i>=0){
            while(!st.isEmpty()&& (map.get(st.peek())<=map.get(arr[i]))){
                st.pop();
            }
            if(st.isEmpty()){
                result.add(-1);
            }
            else{
                result.add(st.peek());
            }
            st.push(arr[i]);
            i--;
        }
        Collections.reverse(result);
        return result;
    }
}
