class Solution {
    public int minMen(int arr[]) {
      
      int n = arr.length;
      
      int maxReach[] = new int [n];
      
      Arrays.fill(maxReach, -1);
      
      for(int i = 0; i< arr.length; i++)
      {
          if(arr[i] != -1)
          {
              int left = Math.max(0, i - arr[i]);
              int right = Math.min(n-1, i + arr[i]);
              
              maxReach[left] = Math.max(maxReach[left], right);
          }
      }
      
      
      if(maxReach[0] == -1)
      {
          return -1;
      }
      
      int currEnd = 0;
      int farthest = 0;
      int i = 0;
      int people = 0;
      
      while(currEnd < n)
      {
          while( i<= currEnd && i < n) {
              
              farthest = Math.max(farthest, maxReach[i]);
              i++;
          }
          
          if(farthest < currEnd) return -1;
          people++;
          currEnd = farthest + 1;
      }
      return people;
        
    }
}
