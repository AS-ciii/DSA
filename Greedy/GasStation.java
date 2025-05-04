class Solution {
    public int startStation(int[] gas, int[] cost) {
        int tg = 0, tc = 0, start = 0, cg = 0;
        
        for(int i=0; i<gas.length; i++) {
            tg += gas[i];
            tc += cost[i];
            cg += gas[i]-cost[i];
            
            if(cg < 0) {
                start = i+1;
                cg = 0;
            }
        }
        
        return tg>=tc?start:-1;
    }
}
