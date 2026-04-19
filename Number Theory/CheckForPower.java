class Solution {
    public boolean isPower(int x, int y) {
        if(x == 1 && y > x)
        {
            return false;
        }
       
        double exponent = Math.log(y) / Math.log(x);   //step a.
        int power = (int)Math.round(exponent);            //step b.
        
        return Math.round(Math.pow(x, power)) == y;
    }
}
