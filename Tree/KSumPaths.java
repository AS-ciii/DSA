package Tree;

class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> pMap = new HashMap<>();
        pMap.put(0, 1);
        return dfs(root, 0, k, pMap);
    }
    
    public int dfs(Node node, int currSum, int k, HashMap<Integer, Integer> map) {
        if(node==null) return 0;
        
        currSum += node.data;
        
        int path = map.getOrDefault(currSum-k, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
        path += dfs(node.left, currSum, k, map);
        path += dfs(node.right, currSum, k, map);
        
        map.put(currSum, map.get(currSum)-1);
        return path;
    }
}
