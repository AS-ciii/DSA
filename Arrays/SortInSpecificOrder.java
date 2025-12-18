class Solution {
    
    public void sortIt(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        int l = 0;
        int r = n - 1;
        //arranging odd numbers to the right  and even numbers to the left of the array
        while(l < r){
            while((l < n && (arr[l] % 2) != 0)) l++;
            while(((r >= 0) && (arr[r] % 2) != 1)) r--;
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        int lastOddIdx = -1;//finding the index where the last odd value exist
        for(int i = n - 1 ; i >= 0 ; i--){
            if(arr[i] % 2 == 1){
                lastOddIdx = i;
                break;
            }
        }
        if(lastOddIdx != -1){//first sort odd numbers in ascending order then reverse it to make it descending 
            Arrays.sort(arr , 0 , lastOddIdx + 1);
            int o = 0;
            int p = lastOddIdx;
            while(o < p){
                int temp = arr[o];
                arr[o] = arr[p];
                arr[p] = temp;
                o++;
                p--;
            }
        }////Sort the even numbers
        if((lastOddIdx + 1) < n){
            Arrays.sort(arr , lastOddIdx + 1 , n);
        }
        
    }
}
