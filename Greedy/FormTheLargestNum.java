class Solution {
    public String findLargest(int[] arr) {
        // code here
        // Step 1: Convert int array to String array
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        
        // Step 2: Custom sort
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        // Step 3: Edge case (all zeros)
        if (str[0].equals("0")) {
            return "0";
        }
        
        // Step 4: Concatenate result
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s);
        }
        
        return result.toString();
    }
}
