class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        //Now comes the actual algorithm line-sweep algo
        int n=intervals.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int it[]:intervals){
            int start=it[0];
            int end=it[1];
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end+1,map.getOrDefault(end+1,0)-1);
        }
        //System.out.println(map);
        int sum=0;
        int ans=-1;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            int key=it.getKey();
            int value=it.getValue();
            sum+=value;
            if(sum>=k){
                ans=Math.max(ans,key);
            }
            else if((sum-value)>=k){
                ans=Math.max(ans,key-1);
            }
        }
        return ans;
    }
}
