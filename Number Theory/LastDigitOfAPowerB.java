class Solution {
    public int getLastDigit(String a, String b) {
        if(b.equals("0")) return 1;
        if(a.equals("0")) return 0;
        
        // reducing a
        int base=a.charAt(a.length()-1)-'0';
        
        // reducing b
        int exp=0;
        if(b.length()>=2) {
            String lastTwo=b.substring(b.length()-2);
            exp=Integer.parseInt(lastTwo)%4;
        }
        else exp=Integer.parseInt(b)%4;
        if(exp==0) exp=4;
        
        // calculate (a^b)%10 
        int res=(int)Math.pow(base,exp);
        return res%10; 
    }
};
