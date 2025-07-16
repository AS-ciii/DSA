class Solution {
    public static int countNumbers(int n) {
        // code here
        int s=(int)(Math.sqrt(n));
        ArrayList<Integer> p = new ArrayList<>();
       int c=0;
        for(int i=2;i<=s;i++){
            for(int j=2;j<=i/2;j++){
                if(i%j==0) c++;
            }
            if(c==0){
                p.add(i);
            }
            c=0;
        }
        int d=0;
        for(int i=0;i<p.size();i++){
            if(n>=(Math.pow(p.get(i),8))) d++;
            else break;
        }
        for(int i=0;i<p.size();i++){
            for(int j=i+1;j<p.size();j++){
                if(s>=p.get(i)*p.get(j)) d++;
                else break;
            }
        }
        
        return d;
    }
}

