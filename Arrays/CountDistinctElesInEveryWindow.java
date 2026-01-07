class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
    
        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        res.add(map.size());
        
        for(int i=0;i<arr.length-k;i++){
            if(map.get(arr[i]) == 1) map.remove(arr[i]);
            else map.put(arr[i], map.get(arr[i])-1);
            map.put(arr[i+k], map.getOrDefault(arr[i+k], 0)+1);
            res.add(map.size());
        }
        
        // for(int i=0;i<=arr.length-k;i++){
        //     // ArrayList<Integer> temp = new ArrayList<>();
        //     HashSet<Integer> temp = new HashSet<>();
        //     for(int j=i;j<i+k;j++){
        //         if(!temp.contains(arr[j]))
        //         temp.add(arr[j]);
        //     }
        //     res.add(temp.size());
        // }
        
        return res;
    }
}
