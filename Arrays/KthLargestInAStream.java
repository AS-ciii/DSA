class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {

        int n = arr.length;
        int[] ans = new int[n];
        int[] a = new int[k];
        
        for(int i = 0; i < k; i++)
        {
            ans[i] = -1;
            a[i] = arr[i];
        }
        Arrays.sort(a);
        
        ans[k-1] = a[0];
        for(int i = k; i < n; i++)
        {
            int j, x = arr[i];
            for(j = 0; j < k; j++)
            {
                if(a[j] >= x)
                    break;
            }
            for(int kj = 0; kj < j-1; kj++)
                a[kj] = a[kj+1];
            if(j > 0)
                a[j-1] = x;
            ans[i] = a[0];
        }
        
        ArrayList<Integer> sol = new ArrayList<>();
        for(int i: ans)
            sol.add(i);
            
        return sol;
    }
}
