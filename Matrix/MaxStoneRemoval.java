class Solution {
    HashMap<Integer , ArrayList<Integer>> xAxis = new HashMap<>() ,yAxis = new HashMap<>();
    int maxRemove(int[][] stones) {
        int V = stones.length ,ans=0;
        boolean[] isV = new boolean[V];
        for (int i = 0; i < V; i++) {
            xAxis.computeIfAbsent(stones[i][0], k1 -> new ArrayList<>()).add(i);
            yAxis.computeIfAbsent(stones[i][1], k1 -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < V; i++)
            if(!isV[i]) ans+=rec(i,stones,isV)-1;
        return ans;
    }
    public int rec(int i , int[][] stones , boolean[] isV){
        if(isV[i]) return 0;
        isV[i]=true;
        int ans =1;
        for(int k : xAxis.get(stones[i][0]))
            if(!isV[k]) ans+=rec(k,stones,isV);
        for(int k : yAxis.get(stones[i][1]))
            if(!isV[k])ans+=rec(k,stones,isV);
        return ans;
    }
};
