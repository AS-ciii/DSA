class Solution {
    public int cntWays(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 1){
            return 1;
        }
        ArrayList<Integer> oneLeftShift = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i != 0){
                oneLeftShift.add(arr[i]);
            }
        }
        ArrayList<ArrayList<Integer>> prefixEvenOddSum = new ArrayList<>();
        int evenSum = 0;
        int oddSum = 0;
        for(int i = 0 ; i < oneLeftShift.size() ; i++){
            if(i % 2 == 0){
                evenSum += oneLeftShift.get(i);
            }else{
                oddSum += oneLeftShift.get(i);
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(evenSum);//index 0
            temp.add(oddSum);//index 1
            
            prefixEvenOddSum.add(temp);
        }
        int evenSumUptoim1 = 0;
        int oddSumUptoim1 = 0;
        int m = oneLeftShift.size();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int evenSumUpToNm1 = prefixEvenOddSum.get(m-1).get(0);
            int totalEvenSum = evenSumUpToNm1 - ((i - 1 < 0) ? 0 : prefixEvenOddSum.get(i-1).get(0));
            
            int oddSumUpToNm1 = prefixEvenOddSum.get(m-1).get(1);
            int totalOddSum = oddSumUpToNm1 - ((i - 1 < 0) ? 0 : prefixEvenOddSum.get(i - 1).get(1));
            
            int grandTotalEvenSum = totalEvenSum + evenSumUptoim1;
            int grandTotalOddSum = totalOddSum + oddSumUptoim1;
            
            if((grandTotalEvenSum - grandTotalOddSum) == 0){
                count++;
            }
            
            if(i % 2 == 0){
                evenSumUptoim1 += arr[i];
            }else{
                oddSumUptoim1 += arr[i];
            }
        }
        return count;
    }
}
