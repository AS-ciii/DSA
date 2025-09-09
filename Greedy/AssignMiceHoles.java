class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int curr=0, max=0;
        for(int i=0; i<mices.length; i++){
            curr=Math.abs(mices[i] - holes[i]);
            max=Math.max(max,curr);
        }
        
        return max;
    }
};
