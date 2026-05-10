class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        // code here
        int n = a.length;
        List<int[]> tasks = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int diff = Math.abs(a[i] - b[i]);
            tasks.add(new int[]{diff, a[i], b[i]});
        }
        Collections.sort(tasks, (t1, t2) -> t2[0] - t1[0]);
        int profit = 0;
        for(int[] task : tasks){
            int ai = task[1];
            int bi = task[2];
            if(ai > bi){
                if(x > 0){
                    profit += ai;
                    x--;
                }
                else{
                    profit += bi;
                    y--;
                }
            }
            else{
                if(y > 0){
                    profit += bi;
                    y--;
                }
                else{
                    profit += ai;
                    x--;
                }
            }
        }
        return profit;
    }
}
