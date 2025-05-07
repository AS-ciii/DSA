class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        
        
        for(int i=0; i<n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a,b)->b.profit - a.profit);
        
        int maxDL = 0;
        for(Job job : jobs) {
            maxDL = Math.max(maxDL, job.deadline);
        }
        
        int[] s = new int[maxDL+1];
        Arrays.fill(s, -1);
        int cj = 0;
        int mp = 0;
        
        
        for(Job job : jobs) {
            for(int slot = job.deadline; slot>0; slot--) {
                if(s[slot]==-1) {
                    s[slot] = job.profit;
                    cj++;
                    mp += job.profit;
                    break;
                    
                }
            }
        }
        
        return new ArrayList<>(Arrays.asList(cj, mp));
        
    }
    
    static class Job {
        int deadline;
        int profit;
        
        Job(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }
}
