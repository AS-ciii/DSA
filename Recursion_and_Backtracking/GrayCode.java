class Solution {
    public ArrayList<String> graycode(int n)
    {
        //code here
        
        if(n==1){
            ArrayList<String> al1 = new ArrayList<String>();
            al1.add("0");
            al1.add("1");
            return al1;
        }
        ArrayList<String> al = graycode(n-1);
        for(int i=al.size()-1;i>=0;i--){
            al.add(al.get(i));
        }
        int j= al.size()/2;
        for(int i=0;i<al.size();i++){
            if(i<j){
                al.set(i,"0"+al.get(i));
            }
            else{
                al.set(i,"1"+al.get(i));
            }
        }
        
        return al;
        
        
    }
}
