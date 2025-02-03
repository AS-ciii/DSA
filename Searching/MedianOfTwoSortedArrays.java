package Searching;

class Solution {
    public double medianOf2(int a[], int b[]) {
        int len1 = a.length;
        int len2 = b.length;
        
        if(len1>len2) return medianOf2(b, a);
        
        int totlen = len1+len2;
        
        int low = 0, high = len1;
        int left = (totlen+1)/2;
        
        while(low<=high) {
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            
            int l1 = (mid1-1>=0)?a[mid1-1]:Integer.MIN_VALUE;
            int l2 = (mid2-1>=0)?b[mid2-1]:Integer.MIN_VALUE;
            int r1 = (mid1<len1)?a[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<len2)?b[mid2]:Integer.MAX_VALUE;
            
            if(l1<=r2 && l2<=r1) {
                if(totlen%2==1) return (double)Math.max(l1, l2);
                else return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
            else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        
        return 0;
    }
}