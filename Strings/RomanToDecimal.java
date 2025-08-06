class Solution {
    public int romanToDecimal(String s) {
        // code here
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        int ans = 0;
        int i;
        for (i = 0; i < s.length()-1; i++){
        // System.out.println(i);
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if (values.get(a) < values.get(b)){
                ans += Math.abs(values.get(a)-values.get(b));
                i++;
            }
            else{
                ans += values.get(a);
            }
        }
        if (i == s.length()-1)
            ans += values.get(s.charAt(s.length()-1));
        return ans;
    }
}
