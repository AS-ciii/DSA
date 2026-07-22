class Solution {
    public int binaryIndex(int[] arr,int ind,int ele) {
        int start=0,end=ind,ans=-1;
        while(start<=end) {
            int mid=(start+end)>>1;
            if(arr[mid]>=ele) {
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
    public int minDeletions(int[] arr) {
        // code here
        int n=arr.length;
        int[] larr=new int[n];
        int ind=-1;
        for(int i=0;i<n;i++) {
            if(ind==-1 || (ind!=-1 && larr[ind]<arr[i])) larr[++ind]=arr[i];
            else larr[binaryIndex(larr,ind,arr[i])]=arr[i];
        }
        return n-(ind+1);
    }
}
