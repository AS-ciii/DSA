class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        int rows=mat.length;
        int col=mat[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<col;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0;j<rows;j++){
                temp.add(mat[j][i]); 
            }
            list.add(temp);
            
        }
        return list;
         
    }
}
