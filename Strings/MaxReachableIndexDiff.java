class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int st = -1;
        int n = s.length();
        int prev = -1;
        int en = -1;
        for(int i = 0; i < n; i++){
            int curr = s.charAt(i) - 'a';
            if(st == -1 && curr == 0){
                st = i;
                prev = 0;
                en = i;
            } else if(curr == 0){
                continue;
            } else if(curr - prev == 1){
                en = i;
                prev = curr;
            } else if(curr - prev <= 0){
                
                en = i;
            }
            
        }
        if(st == -1) return -1;
        
        return en - st;
    }
}
