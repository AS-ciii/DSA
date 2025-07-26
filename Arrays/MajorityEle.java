class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if(arr==null||arr.length==0)
        return res;
        
        int n = arr.length;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int ele:arr)
        {
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()>Math.floor(n/3))
            res.add(e.getKey());
        }
        return res;
    }
}
