
Prince Kumar
10 hours agoApr 10, 2026 12:34 (GMT +5:30)

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        int ans1=Integer.MAX_VALUE;
        int ans2=Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            
              if(arr[i]>ans2){
                   ArrayList<Integer>l=new ArrayList<>();
                   l.add(ans1);
                   l.add(ans2);
                   l.add(arr[i]);
                   return l;
              }
              
              
              
              if(arr[i]<first){
                  first=arr[i];
              }
              else if(arr[i]<second){
                  second=arr[i];
              }
              
              if(second!=Integer.MAX_VALUE && first<second && second<ans2){
                   ans1=first;
                   ans2=second;
              }
              
              //System.out.println(ans1+" "+ans2);
              
              
        }
        
        return new ArrayList<>();
        
        
    }
}
