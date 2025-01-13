package Strings;

class Solution {
    
    public static String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] lessThan100 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] Thousands = {"", "Thousand", "Million", "Billion"};
        
    String convertToWords(int n) {
        if(n==0) return "Zero";
        
        StringBuilder words = new StringBuilder();
        int idx = 0;
        
        while(n>0) {
            if(n%1000!=0) words.insert(0, toWords(n%1000)+Thousands[idx]+" ");
            n /= 1000;
            idx++;
        }
        
        return words.toString().trim();
    }
    
    private static String toWords(int n) {
        if(n==0) return "";
        else if(n<20) return lessThan20[n]+" ";
        else if(n<100) return lessThan100[n/10]+" "+toWords(n%10);
        else return lessThan20[n/100]+" Hundred "+toWords(n%100);
    }
}
