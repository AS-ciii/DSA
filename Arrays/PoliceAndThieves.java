class Solution {
    public int catchThieves(char[] arr, int k) {
        int n=arr.length;
        int ans=0, pPos=0, tPos=0;
        
        while(pPos<n && tPos<n) {
            // trying to reach P valid position
            if(arr[pPos]!='P' || tPos - pPos>k) {
                pPos++;
                continue;
            }
            
            // trying to reach T valid position
            if(arr[tPos]!='T' || pPos - tPos>k) {
                tPos++;
                continue;
            }
            
            ans++;
            pPos++;
            tPos++;
        }
        return ans;
    }
}
