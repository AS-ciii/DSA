class Solution {
    
    private long[] seg;
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    
    private void build(int idx, int low, int high, int[] arr) {
        
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }
        
        int mid = (low + high) / 2;
        
        build(2 * idx + 1, low, mid, arr);
        build(2 * idx + 2, mid + 1, high, arr);
        
        seg[idx] = lcm(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    
    private void update(int idx, int low, int high, int pos, int val) {
        
        if (low == high) {
            seg[idx] = val;
            return;
        }
        
        int mid = (low + high) / 2;
        
        if (pos <= mid) {
            update(2 * idx + 1, low, mid, pos, val);
        } else {
            update(2 * idx + 2, mid + 1, high, pos, val);
        }
        
        seg[idx] = lcm(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    
    private long query(int idx, int low, int high, int l, int r) {
        
        if (r < low || high < l) {
            return 1;
        }
        
        if (l <= low && high <= r) {
            return seg[idx];
        }
        
        int mid = (low + high) / 2;
        
        long left = query(2 * idx + 1, low, mid, l, r);
        long right = query(2 * idx + 2, mid + 1, high, l, r);
        
        return lcm(left, right);
    }
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        seg = new long[4 * n];
        
        build(0, 0, n - 1, arr);
        
        ArrayList<Long> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            
            if (q[0] == 1) {
                
                int index = q[1];
                int value = q[2];
                
                update(0, 0, n - 1, index, value);
                
            } else {
                
                int l = q[1];
                int r = q[2];
                
                ans.add(query(0, 0, n - 1, l, r));
            }
        }
        
        return ans;
    }
}

