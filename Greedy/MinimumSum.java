class Solution {
    
    String sumString(String num1, String num2){
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0){
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum%10);
            carry = sum/10;
        }
        while(result.length() > 1 && result.charAt(result.length()-1) == '0'){
            result.setLength(result.length()-1);
        }
        return result.reverse().toString();
    }
    
    String minSum(int[] arr) {
        // code here
        int n = arr.length;
        int[] freq = new int[10];
        for(int i=0; i<n; i++){
            freq[arr[i]]++;
        } 
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        boolean flag = false;
        for(int i=1; i<=9; i++){
            for(int j=0; j<freq[i]; j++){
                if(flag){
                    num1.append(i);
                }
                else{
                    num2.append(i);
                }
                flag = !flag;
            }
        }
        return sumString(num1.toString(), num2.toString());
    }
}
