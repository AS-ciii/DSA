/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> InoL = new ArrayList<>();

    public void store(Node root) {
        if (root == null) return;
        store(root.left);
        InoL.add(root.data);
        store(root.right);
    }

    public int lowerB(List<Integer> inor, int target) {
        int low = 0, high = inor.size();
      
        while (low <high) {
            int mid = low + (high - low) / 2;
            if (inor.get(mid) < target){
                 low = mid + 1;
        
            }
               
            else if(inor.get(mid)==target) return mid;
            
            else
                high = mid;
        }
        return low;
    }

    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        store(root);
        int idx = lowerB(InoL, target);
        int left = idx - 1;
        int right = idx;

        ArrayList<Integer> ans = new ArrayList<>(); // <-- fix: declare ans

        while (k-- > 0) {
            if (left < 0) {
                ans.add(InoL.get(right++));
            } else if (right >= InoL.size()) {
                ans.add(InoL.get(left--));
            } else {
                if (Math.abs(InoL.get(left) - target) <= Math.abs(InoL.get(right) - target))
                    ans.add(InoL.get(left--));
                else
                    ans.add(InoL.get(right++));
            }
        }

        return ans;
    }
}
