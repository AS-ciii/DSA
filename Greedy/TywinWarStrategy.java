class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int cnt=0; int need=(arr.length+1)/2;
        int tot=0; int [] freq=new int[k+1];
        for(int i=0;i<arr.length;i++)
        {
           int add = (k - (arr[i] % k)) % k;
           freq[add]++;
        }
        for(int i=0;i<freq.length;i++)
        {
            if(cnt+freq[i]<need)
            {
                cnt+=freq[i];
                tot+=(freq[i])*i;
            }
            else{
                int rest=need-cnt;
                tot+=(rest)*i;
                break;
            }
        }
        return tot;
    }
}
