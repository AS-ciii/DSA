class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]> ansList = new ArrayList<>();
        Arrays.sort(arr , (a , b) ->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }
        });
        int n = arr.length;
        
        int min = arr[0][0];
        int max = arr[0][1];
        
        for(int i = 1 ; i < n ; i++){
            int val1 = arr[i][0];
            int val2 = arr[i][1];
            
            if(val1 >= min && val1 <= max){
                max = Math.max(val2 , max);
            }else{
                int[] newArr = new int[2];
                newArr[0] = min;
                newArr[1] = max;
                ansList.add(newArr);
                
                min = val1;
                max = val2;
            }
        }
        int[] newArr = new int[2];
        newArr[0] = min;
        newArr[1] = max;
        ansList.add(newArr);
        return ansList;
    }
}
