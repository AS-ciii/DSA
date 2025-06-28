class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        int maxVal = 0;
        for (int num : a) maxVal = Math.max(maxVal, num);
        for (int num : b) maxVal = Math.max(maxVal, num);
        
        int[] freq = new int[maxVal + 1];
        
        for (int num : b){
            freq[num]++;
        }
        
        for(int i=1; i <= maxVal; i++){
            freq[i] += freq[i - 1];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : a){
            result.add(freq[num]);
        }
        
        return result;
    }
}
