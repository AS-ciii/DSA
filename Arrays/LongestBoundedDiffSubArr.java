class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int minIdx = n;
        int maxSize = 0;
        int[] ns = new int[n];
        int[] ng = new int[n];
        
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ns[n-1] = n;
        s.push(n-1);
        ng[n-1] = n;
        s2.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            
            while(!s2.isEmpty() && arr[s2.peek()] <= arr[i]) s2.pop();
            
            ns[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
            
            ng[i] = s2.isEmpty() ? n : s2.peek();
            s2.push(i);
        }
        int nsIdx = 0;
        int ngIdx = 0;
        
        for(int l = 0, r = 0; r < n; r++){
            nsIdx = find(ns,nsIdx,l,r,n);
            ngIdx = find(ng,ngIdx,l,r,n);
            int minEl = arr[nsIdx];
            int maxEl = arr[ngIdx];
            
            int size = r-l+1;
            if(maxEl - minEl <= x){
                if(size > maxSize){
                    maxSize = size;
                    minIdx = l;
                }
            }else{
                l++;
                if(l < n){
                    nsIdx = l;
                    ngIdx = l;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0, j = minIdx; i < maxSize; i++,j++){
            list.add(arr[j]);
        }
        
        return list;
    }
    private int find(int[] ns, int nsIdx, int l, int r, int n){
        while(nsIdx < n && ns[nsIdx] >= l && ns[nsIdx] <= r){
            nsIdx = ns[nsIdx];
        }
        return nsIdx;
    }
}
