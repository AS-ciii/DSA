package Sorting;

class Solution {
    public String findLargest(int[] arr) {
        
        String[] strArr = new String[arr.length];
        for(int i=0; i<arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strArr, (a, b)->(b+a).compareTo(a+b));

        if(strArr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for(String s : strArr) {
            result.append(s);
        }

        return result.toString();
    }
}

