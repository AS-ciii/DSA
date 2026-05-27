class Solution {
    public boolean wifiRange(String s, int x) {
        // code here
        boolean[] range = new boolean[s.length()];
        int prev = -10000000;
        //Mark all the rooms covered with wifi from left side
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                prev = i;
                range[i] = true;
            }else if(prev+x >= i){
                range[i] = true;
            }
        }
        //Mark all the rooms covered with wifi from right side
        prev = 10000000;
        for(int i=s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                prev = i;
                range[i] = true;
            }else if(prev-x <= i){
                range[i] = true;
            }
        }
        //check if all the rooms covered with wifi
        for(boolean cover: range){
            if(!cover) return false;
        }
        return true;
    }
}
