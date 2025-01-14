package Sorting;

class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        Arrays.sort(citations);  // Sort the citations array
        int hIndex = 0;
        
        for(int i=0; i<citations.length; i++) {
            int len = citations.length-i;
            if(citations[i] >= len) {
                hIndex = len;
                break;
            }
        }
        
        return hIndex;
    }
}
