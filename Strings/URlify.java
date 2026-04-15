class Solution {
    String URLify(String s) {
        // code here
        s=s.replace(" ", "%20");
        return s;
    }
    public static void main(String[] args) {
        Solution obj=new Solution();
        System.out.println(obj.URLify("i love programming"));
}
}
