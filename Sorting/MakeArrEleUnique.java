package Sorting;

class Solution {
    public int minIncrements(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++) {
            if(arr[i]<=arr[i-1]) {
                int increment = arr[i-1]-arr[i]+1;
                arr[i] += increment;
                count += increment;
            }
        }
        
        return count;
    }
}

