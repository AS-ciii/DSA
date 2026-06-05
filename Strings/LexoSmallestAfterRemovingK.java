class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
            int n=s.length();
            if((n&(n-1))==0) k/=2;
            else k*=2;
            if(k>=n) return "-1";
            StringBuilder st = new StringBuilder();
            int remove =k;
            for(char ch : s.toCharArray()){
                while(st.length()>0 && remove >0 && st.charAt(st.length()-1)>ch){
                    st.deleteCharAt(st.length()-1);
                    remove--;
                }
                st.append(ch);
            }
            
            while(remove > 0){
                st.deleteCharAt(st.length()-1);
                remove--;
            }
            return st.length() ==0 ? "-1" : st.toString();
    }
}
