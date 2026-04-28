class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        int l=s.length();
        if(l==0){
            return 0;
        }
        int c[]=new int[26];
        int i=0;
        int j=0;
        int max=0;
        while(i<l){
            int count=++c[s.charAt(i)-'A'];
            
        
        if(count>max){
            max=count;
        }else{
            k--;
        }
        if(k<0){
            --c[s.charAt(j)-'A'];
            k++;
            j++;
        }
        i++;
    }
    return i-j;
    }
}
