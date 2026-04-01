class Solution {
    int countStrings(int n) {
        // code here
        int first = 2;
        if(n == 1) return first;
        
        int second = 3;
        if(n == 2) return second;
        
        int next = 0;
        for(int i = 0; i < n - 2; i++){
            next = first + second;
            first = second;
            second = next;
        }
        
        return next;
    }
}

