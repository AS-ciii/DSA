class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        int l=0,r=0,start=-1,end=-1,maxi=Integer.MAX_VALUE;
        Map<Character,Integer>ans=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char v=p.charAt(i);
            ans.put(v,ans.getOrDefault(v,0)+1);
        }
        int count=0;
        while(r<s.length()){
            if(ans.containsKey(s.charAt(r))){
                if(ans.get(s.charAt(r))>0){
                    count++;
                    ans.put(s.charAt(r),ans.get(s.charAt(r))-1);
                }
                else{
                    ans.put(s.charAt(r),ans.get(s.charAt(r))-1);
                }
            }
            if(count==p.length()){
                while(count==p.length()){
                    if(ans.containsKey(s.charAt(l))){
                        if(ans.get(s.charAt(l))<0)
                            ans.put(s.charAt(l),ans.get(s.charAt(l))+1);
                        else{
                            count--;
                            ans.put(s.charAt(l),ans.get(s.charAt(l))+1);
                        }
                    }
                    l++;
                }
                if(maxi>(r-l+1)){
                    maxi=Math.min(maxi,(r-l+1));
                    start=l-1;
                    end=r+1;
                }
            }
            r++;
        }
        if(start==-1)return "";
        return s.substring(start,end);
    }
}
