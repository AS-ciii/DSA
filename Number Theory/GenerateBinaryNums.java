class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(Integer.toBinaryString(i));
        }
        return result; 
    }
}
