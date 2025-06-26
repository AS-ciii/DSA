class Solution {
    public int minValue(String s, int k) {
        // code here
        int arr[]=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
            if(i!=0) pq.add(i);
        }
        while(k>0){
        int value=pq.poll();
         value--;
         k--;
         if(value>0) pq.add(value);
        }
        int sum=0;
        while(pq.size()>0){
            int value=pq.poll();
            sum+=value*value;

        }
        return sum;
        
        
        
    }
}
