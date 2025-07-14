class Solution {
    
     void f(String str, HashSet<String>set, int psf,int ans[]) {
		if(str.length()==0) {
			ans[0]=Math.min(ans[0], psf);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			String pre=str.substring(0,i+1);
			if(set.contains(pre)) {
				f(str.substring(i+1),set,psf+1,ans);
			}
		}	
		
	} 
    
    public int cuts(String s) {
        HashSet<String> set =new HashSet<>();
		long temp=1;
		set.add("1");
		for(int i=0;i<13;i++) {
			temp=temp*5;
			String str=Long.toBinaryString(temp);
			set.add(str);
		}
	
		int ans[]= {Integer.MAX_VALUE};
		f(s,set,0,ans);
    	return ans[0]==Integer.MAX_VALUE?-1:ans[0]; 
        
    }
}
