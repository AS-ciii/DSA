class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] ans = new int[k];
        int count = 0;
        for(int i:arr){
            count+=ans[i%k];
            ans[(-i%k+k)%k]++;
        }
        return count;
    }
}
