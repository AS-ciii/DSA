class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int i=0;
        int j = k-1;
        int counter=0;
        HashSet<Character> set = new HashSet<>();
        while(j<n){
            for(int index=i;index<=j;index++){
                set.add(s.charAt(index));
            }
            if(set.size()==k-1){
              counter++;
            }
            set.clear();
            i++;
            j++;
        }
        return(counter);
    }
}
