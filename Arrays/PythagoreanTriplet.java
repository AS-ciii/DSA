class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        
        HashSet<Integer> set = new HashSet<>();
        
        //add element in hash
        for(int i : arr){
            set.add(i*i);
        }
        
        
        //check sum exist in hashset or not
        for(int i=0;i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                int sum = arr[i]*arr[i] + arr[j]*arr[j];
                if(set.contains(sum)) return true;
            }
        }
        
        //time complexity On2
        return false;

    }
}
