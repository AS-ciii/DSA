class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int i=0,j=m-1;
        int min=Integer.MAX_VALUE;
        while(j<arr.size()){
            min=Math.min(min,arr.get(j)-arr.get(i));
            j++;
            i++;
        }
        return min;
    }
}
