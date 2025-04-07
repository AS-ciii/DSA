package DP;

class Solution {
    static int lis(int arr[]) {
        if(arr.length==0) return 0;
        
        ArrayList<Integer> li = new ArrayList<>();
        
        for(int num : arr) {
            int pos = Collections.binarySearch(li, num);
            
            if(pos < 0) pos = -(pos+1);
            
            if(pos==li.size()) {
                li.add(num);
            } else li.set(pos, num);
        }
        
        
        return li.size();
    }
}
