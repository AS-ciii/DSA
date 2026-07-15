class Solution {
    public int bitonic(int[] arr) {
        // code here
        int []p=new int[arr.length];
        int []s=new int[arr.length];
        
        p[0]=1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]>=arr[i-1]) {
                p[i]=p[i-1]+1;
            } else {
                p[i]=1;
            }
        }
        
        s[arr.length-1]=1;
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i]>=arr[i+1]) {
                s[i]=s[i+1]+1;
            } else {
                s[i]=1;
            }
        }
        
        
        int ans=0;
        for(int i=0;i<arr.length;i++) {
            ans=Math.max(ans, p[i]+s[i]-1);
        }
        return ans;
    }
}
