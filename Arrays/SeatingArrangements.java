class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int ans=0;
        int count=0;
        
        if(k==1 && seats.length==1 && seats[0]!=1 ){
            return true;
        }
        
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
                count++;
                if(count==2){
                    ans++;
                    count=0;
                }
            }else{
                if(i<seats.length-1 && seats[i+1]==1 ){
                    return false;
                }
                count=0;
            }
        }
        return ans>=k;
    }
}```
