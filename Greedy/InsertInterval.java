class Solution {
    public ArrayList<int[]> insertInterval
    (int[][] intervals, int[] newInterval) {
        // code here
        
        int n = intervals.length;
        int i=0;
        ArrayList<int[]> res = new ArrayList<>();
        //before
        while(i<n && intervals[i][1]<newInterval[0])
        {
            res.add(intervals[i]);
            i++;
        }
        
        //merge overlapping
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0] = 
            Math.min(newInterval[0],intervals[i][0]);
            
            newInterval[1] = 
            Math.max(newInterval[1],intervals[i][1]);
            
            i++;
        }
        res.add(newInterval);
        //after
        
        while(i<n)
        res.add(intervals[i++]);
        
        return res;
    }
}
