package Hashing;

class Solution {
    public static int findUnion(int a[], int b[]) {
        Set<Integer> union = new HashSet<>();
        
        for(int num : a) {
            union.add(num);
        }
        
        for(int num : b) {
            union.add(num);
        }
        
        return union.size();
    }
}
