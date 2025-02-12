package Hashing;

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        if(arr.length==0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : arr) {
            set.add(num);
        }
        
        int max = 0;
        
        for(int num : set) {
            if(!set.contains(num-1)) {
                int current = num;
                int count = 1;
                
                while(set.contains(current+1)) {
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}