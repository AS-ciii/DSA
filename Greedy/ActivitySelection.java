class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        if(n==0) return 0;
        int[][] act = new int[n][2];
        for(int i=0; i<n; i++) {
            act[i][0] = start[i];
            act[i][1] = finish[i];
        }
        
        Arrays.sort(act, (a,b) -> {
            if(a[1]!=b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int count = 1;
        int lft = act[0][1];
        
        for(int i=1; i<n; i++) {
            if(act[i][0]>lft) {
                count++;
                lft = act[i][1];
            }
        }
        
        return count;
    }
}
