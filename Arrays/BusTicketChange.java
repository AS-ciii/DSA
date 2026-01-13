class Solution {
    public boolean canServe(int[] arr) {
        // code here
         int ten = 0, five = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 20){
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else return false;
            }
            
            else if(arr[i] == 10){
                ten++;
                if(five > 0)    five--;
                else return false;
            }
            else five++;
        }
        return true;
    }
}
