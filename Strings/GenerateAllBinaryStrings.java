class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> bin = new ArrayList<>();
        
        for(int i=0; i<Math.pow(2, n); i++){
            String binNum = String.format("%"+n+"s", Integer.toBinaryString(i)).replace(' ', '0');
            
            bin.add(binNum);
        }
        
        return bin;
    }
}
