class Solution {
    int maxOnes(int[] arr) {
        // code here
        int totalOnes=0,curr=0,maxGain=0;
       for(int x : arr) {
           if(x==1) totalOnes++;
           int val=(x==0) ? 1 : -1;
           curr=Math.max(0,curr+val);
           maxGain=Math.max(maxGain,curr);
       }
       return totalOnes + maxGain;
    }
};

