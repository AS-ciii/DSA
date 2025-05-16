class Solution {
    public String findOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> id = new HashMap<>();
        
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                id.putIfAbsent(c, 0);
            }
        }
        
        for(int i=0; i<words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int min = Math.min(w1.length(), w2.length());
            boolean found = false;
            
            
            for(int j=0; j<min; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                
                if(c1!=c2) {
                    if(!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        id.put(c2, id.get(c2)+1);
                    }
                    
                    found = true;
                    break;
                }
            }
            
            if(!found && w1.length() > w2.length()) return "";
        }
        
        Queue<Character> q = new LinkedList<>();
        for(char c : id.keySet()) {
            if(id.get(c)==0) q.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            
            for(char n : graph.get(curr)) {
                id.put(n, id.get(n)-1);
                if(id.get(n)==0) q.offer(n);
            }
        }
        
        return sb.length() == id.size()?sb.toString():"";
        
    }
}
