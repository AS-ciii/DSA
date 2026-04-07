import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) 
    {
        
        int n = men.length;
        
        int[] womenPartner = new int[n];   // woman -> man
        int[] menPartner = new int[n];     // man -> woman
        int[] nextProposal = new int[n];   // next woman to propose
        
        Arrays.fill(womenPartner, -1);
        Arrays.fill(menPartner, -1);
        
        // ranking[woman][man] -> preference rank
        int[][] ranking = new int[n][n];
        
        for(int w = 0; w < n; w++){
            for(int i = 0; i < n; i++){
                ranking[w][women[w][i]] = i;
            }
        }
        
        Queue<Integer> freeMen = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            freeMen.add(i);
        }
        
        while(!freeMen.isEmpty()){
            int man = freeMen.poll();
            
            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;
            
            if(womenPartner[woman] == -1){
                // woman is free
                womenPartner[woman] = man;
                menPartner[man] = woman;
            }
            else{
                int currentMan = womenPartner[woman];
                
                if(ranking[woman][man] < ranking[woman][currentMan]){
                    // woman prefers new man
                    womenPartner[woman] = man;
                    menPartner[man] = woman;
                    
                    menPartner[currentMan] = -1;
                    freeMen.add(currentMan);
                }
                else{
                    freeMen.add(man);
                }
            }
        }
        
        return menPartner;
    }
}

