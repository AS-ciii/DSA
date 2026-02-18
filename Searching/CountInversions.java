class Solution {
    private static List<Integer> list;
    
    static int inversionCount(int arr[]) {
        // Code Here
        list = new ArrayList<>();
        
        int count = 0;
        
        for (int i : arr) {
            count += insert(i);
            // System.out.println(list);
        }
        
        return count;
    }
    
    private static int insert(int num) {
        if (list.isEmpty() || num >= list.get(list.size()-1)) {
            list.add(num);
            return 0;
        }
        
        int n = list.size();
        
        int l = 0;
        int r = n-1;
        
        int pos = r;
        
        while (l <= r) {
            int mid = l + (r-l)/2;
            
            if (list.get(mid) > num) {
                pos = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        
        list.add(pos, num);
        
        return n - pos;
    }
}
