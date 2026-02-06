class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int n = a.length;
        
        int i = 0, j = 0, k = 0;
        int[] ans = new int[3];
        int minDiff = Integer.MAX_VALUE;
        
        while(i < n && j < n && k < n) {
            int currDiff = Math.max(a[i], Math.max(b[j], c[k])) - Math.min(a[i], Math.min(b[j], c[k]));
            if(minDiff > currDiff) {
                ans[0] = a[i];
                ans[1] = b[j];
                ans[2] = c[k];
                minDiff = currDiff;
            }
            if(a[i] <= b[j] && a[i] <= c[k]) i++;
            else if(b[j] <= a[i] && b[j] <= c[k]) j++;
            else k++;
        }
        Arrays.sort(ans);
        i = 0;
        j = 2;
        while(i <= j) {
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
        return ans;
    }
}
