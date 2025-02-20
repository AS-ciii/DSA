package Two_Pointer_Technique;

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length-1;
        
        while(left<right) {
            int currSum = arr[left]+arr[right];
            if(Math.abs(target-currSum)<min) {
                min = Math.abs(target-currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            if(currSum<target) left++;
            else if(currSum>target) right--;
            else return res;
        }
        
        return res;
    }
}
