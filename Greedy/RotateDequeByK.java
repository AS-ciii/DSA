class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        if(type == 1) {
            while (k != 0) {
                dq.addFirst(dq.removeLast());
                k--;
            }
        }else {
            while (k != 0){
                dq.addLast(dq.removeFirst());
                k--;
            }
        }
    }
}
