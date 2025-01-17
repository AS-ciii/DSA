package Sorting;

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> updated = new ArrayList<>();
        
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]) {
            updated.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        updated.add(newInterval);
        while(i<intervals.length) {
            updated.add(intervals[i]);
            i++;
        }
        return updated;
    }
}
