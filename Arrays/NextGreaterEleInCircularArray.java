class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int c=0;
        ArrayList<Integer>ar=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    ar.add(arr[j]);
                    c=1;
                    break;
                }
            }
            if(c==0){
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[i]){
                        c=1;
                        ar.add(arr[j]);
                        break;
                    }
                }
            }
            if(c==0)ar.add(-1);
            c=0;
        }
      
        return ar;
    }
}
