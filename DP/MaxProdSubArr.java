class Solution {
    int maxProduct(int[] arr) {
        
        int prd = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;
            
            pre *= arr[i];
            suf *= arr[n-1-i];
            prd = Math.max(prd, Math.max(pre, suf));
        }
        return prd;
    }
}
