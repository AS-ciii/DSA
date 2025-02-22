package Two_Pointer_Technique;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<=arr.length-k; i++) {
            int distinct = 0;
            for(int j=i; j<i+k; j++) {
                boolean isDistinct = true;
                for(int m=i; m<j; m++) {
                    if(arr[j]==arr[m]) {
                        isDistinct = false;
                        break;
                    }
                }
                if(isDistinct) distinct++;
            }
            res.add(distinct);
        }
        return res;
    }
}
