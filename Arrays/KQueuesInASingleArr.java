class kQueues {
    int c;
    int n;
    ArrayList<ArrayList<Integer>> res;
    kQueues(int z, int k) {
        // Initialize your data members
        c=0;
        n=z;
        res=new ArrayList<>();
        for(int i=0;i<k;i++)
        res.add(new ArrayList<>());
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        c++;
        res.get(i).add(x);
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        if(res.get(i).size()==0)
        {
            return -1;
        }
        else
        {
            c--;
            int a=res.get(i).get(0);
            res.get(i).remove(0);
            return a;
        }
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        if(res.get(i).size()==0)
        return true;
        return false;
    }

    boolean isFull() {
        // check if array is full
        if(c==n)
        return true;
        return false;
    }
}
