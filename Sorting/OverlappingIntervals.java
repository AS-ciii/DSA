package Sorting;

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        
        if(arr==null || arr.length==0) {
            return new ArrayList<>();
        }

        List<int[]> overlapped = new ArrayList<>();
        
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        
        int[] currStart = arr[0];
        overlapped.add(currStart);
        
        for(int i=1; i<arr.length; i++) {
            int currEnd = currStart[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];
            
            if(currEnd>=nextStart) {
                currStart[1] = Math.max(currEnd, nextEnd);
            } else {
                currStart = arr[i];
                overlapped.add(currStart);
            }
        }
        
        return overlapped;
    }
}