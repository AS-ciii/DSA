class Solution {
    public int celebrity(int mat[][]) {
        // code here
        if(mat.length==1) return 0;
        int result=-1;
        int index=-1;

        for(int i=0;i<mat.length;i++){
            int flag=1;
            for(int j=0;j<mat.length;j++){
                if(mat[j][i]==0) flag=0;
                
                
            }
            if(flag==1){
                index=i;
                break;
                
            } 
        }
        
        if(index!=-1){
            for(int j=0;j<mat.length;j++){
                if(index!=j && mat[index][j]==1){
                    index=-1;
                    break;
                    
                }
                
                
            }
            
        }
        
        return index;
    }
}
