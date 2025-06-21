class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        int police = 0, thief = 0, count = 0;
        
        while(police < n && thief < n){
            while(police < n && arr[police] != 'P') police++;
            while(thief < n && arr[thief] != 'T') thief++;
            
            if(police < n && thief < n){
                if(Math.abs(police - thief) <= k){
                    count++;
                    police++;
                    thief++;
                }else if(thief < police){
                    thief++;
                }else{
                    police++;
                }
            }
        }
        
        return count;
    }
}
