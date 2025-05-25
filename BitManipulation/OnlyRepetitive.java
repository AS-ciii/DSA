class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];
        
        for(int num : arr) {
            if(count[num]==1) return num;
            count[num]++;
        }
        
        return -1;
        
    }
}
