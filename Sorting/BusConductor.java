class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        // code here
        int sum=0;
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        for(int i=0;i<chairs.length;i++){
            sum+=Math.abs(chairs[i]-passengers[i]);
        }
        return sum;
    }
}
