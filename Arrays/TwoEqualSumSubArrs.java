class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int rsum=0,lsum=0;
        
        for(int i:arr)rsum+=i;
        
        for(int i:arr){
            lsum+=i;
            rsum-=i;
            if(lsum==rsum)return true;
        }
        return false;
    }
}

