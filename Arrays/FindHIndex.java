class Solution {
    public int hIndex(int[] citations) {
        // Find length of citations
        int n=citations.length;
        
        // Finding maximum length value for new arr
        int max=0;
        for(int i=0; i<n; i++){
            max=Math.max(max, citations[i]);
        }
        max=Math.max(max, n);
        int[] arr=new int[max+1];
        
        // Assign value of occuring according to index no.
        for(int i=0; i<n; i++){
            int x=citations[i];
            arr[x]+=1;
        }
        
        // Returning the value that occuring more then the index
        for(int i=arr.length-2; i>=0; i--){
            arr[i]+=arr[i+1];
            if(i<=arr[i]){
                return i;
            }
        }
        return 0;
    }
} 
