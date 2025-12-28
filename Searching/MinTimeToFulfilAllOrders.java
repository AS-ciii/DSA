class Solution {
    
    public long perchef(int[]ranks,long mid){
        //long sum=0;
         long sum=0;
        for(int i=0;i<ranks.length;i++){
long val = (long)((-ranks[i] + Math.sqrt(ranks[i]*ranks[i] + 8L*ranks[i]*mid)) / (2*ranks[i]));
            sum+=val;
        }
          return sum;   
        }
      
    
    public int minTime(int[] ranks, int n) {
     Arrays.sort(ranks);
     int r=ranks.length;
     long low=0;
     long high=ranks[r-1]*n*(n+1)/2;
     long time=0;
     while(low<=high){
    long mid=(low+high)/2;
         long val=perchef(ranks,mid);
         if(val>=n){
             time=(int)mid;
             high=mid-1;
         }else{
             low=mid+1;
         }
         
     }
     
    return (int)time;    
    }
}
