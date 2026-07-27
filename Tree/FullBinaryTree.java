import java.util.*;

class Solution {

    int preIndex = 0;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, preMirror, map, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int[] preMirror,
                       HashMap<Integer, Integer> map,
                       int l, int r) {

        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == r || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);

        root.left = build(pre, preMirror, map, idx, r);
        root.right = build(pre, preMirror, map, l + 1, idx - 1);

        return root;
    }
}
