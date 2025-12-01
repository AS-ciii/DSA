class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }
    
    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 15; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) node.child[bit] = new TrieNode();
            node = node.child[bit];
            node.count++;
        }
    }
    
    private int query(TrieNode root, int num, int k) {
        TrieNode node = root;
        int res = 0;
        for (int i = 15; i >= 0 && node != null; i--) {
            int nBit = (num >> i) & 1;
            int kBit = (k >> i) & 1;
            if (kBit == 1) {
                if (node.child[nBit] != null) res += node.child[nBit].count;
                node = node.child[nBit ^ 1];
            } else {
                node = node.child[nBit];
            }
        }
        return res;
    }
    
    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int ans = 0;
        for (int num : arr) {
            ans += query(root, num, k);
            insert(root, num);
        }
        return ans;
    }
}
