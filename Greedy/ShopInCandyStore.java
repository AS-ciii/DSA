class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int len = prices.length;
        int n =len,i=0;
        Arrays.sort(prices);
        
        int mini =0,maxi =0;
        while(len>0){
            mini+=prices[i];
            maxi+=prices[n-i-1];
            len= len-k-1;
            i++;
        }
        ArrayList<Integer> res = new ArrayList<>();
    res.add(mini); res.add(maxi);
    return res;
    }
}
