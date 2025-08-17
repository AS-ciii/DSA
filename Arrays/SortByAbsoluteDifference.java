class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer[] array = new Integer[arr.length];

        for(int i=0; i< arr.length; i++){
            array[i] = arr[i];
        }

        Arrays.sort(array,(a,b) -> Integer.compare(Math.abs(x-a),Math.abs(x-b)));

        for(int i=0; i<arr.length; i++){
            arr[i] = array[i];
        }
    }
}
