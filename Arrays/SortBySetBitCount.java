class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        ArrayList<pair> lis = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int count = countSetBits(arr[i]); 
            lis.add(new pair(arr[i], count, i)); 
        }
        
        // Sort:
        // 1. Higher set bits first
        // 2. If equal, smaller index first (maintain original order)
        Collections.sort(lis, (a, b) -> {
            if (a.count != b.count) {
                return b.count - a.count; 
            }
            return a.index - b.index; 
        });
        
        for (pair p : lis) {
            ans.add(p.getValue());
        }
        
        return ans;
    }
    
    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }
}

class pair {
    int value;
    int count;
    int index; 
    
    pair(int value, int count, int index) {
        this.value = value;
        this.count = count;
        this.index = index;
    }
    
    public int getValue() {
        return value;
    }
}
