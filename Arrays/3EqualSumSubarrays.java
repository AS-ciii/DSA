package Arrays;

class Solution {

    public List<Integer> findSplit(int[] arr) {
        List<Integer> ans = new ArrayList<>(Arrays.asList(-1, -1));
        int arrSum = 0;
        for(int ele : arr) arrSum += ele;
        
        if(arrSum%3!=0) return ans;
        
        int reqSum = arrSum/3;
        int currSum = 0;
        int firstEle = -1;
        int secondEle = -1;
        
        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            if(currSum==reqSum && firstEle==-1) firstEle = i;
            if(currSum==2*reqSum && secondEle==-1) secondEle = i;
            
            if(firstEle!=-1 && secondEle!=-1) {
                ans.set(0, firstEle);
                ans.set(1, secondEle);
                return ans;
            }
        }
        return ans;
    }
}
